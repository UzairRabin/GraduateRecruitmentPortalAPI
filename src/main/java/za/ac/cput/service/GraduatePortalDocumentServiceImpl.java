package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.GraduateRecruitmentPortalAPI;
import za.ac.cput.model.GraduatePortalDocument;
import za.ac.cput.model.GraduatePortalDocument;
import za.ac.cput.repository.IGraduatePortalDocumentRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author Mbuso Kotobe
 *
 * */
@Service
@Slf4j
public class GraduatePortalDocumentServiceImpl implements IGraduatePortalDocumentService{
    
    private final IGraduatePortalDocumentRepository repository;
    private GraduatePortalDocument document = null;

    @Autowired
    public GraduatePortalDocumentServiceImpl(IGraduatePortalDocumentRepository repository)
    {
        this.repository = repository;
    }


    @Override
    public GraduatePortalDocument save(GraduatePortalDocument object)
    { throw new UnsupportedOperationException(); }

    public GraduatePortalDocument save(MultipartFile file, Long userId) throws IllegalStateException
    {
        try {
            String userDocumentDirectory = GraduateRecruitmentPortalAPI
                    .getUserDocumentsDirectory(userId)
                    .concat(file.getName()).concat("//");

            document = GraduatePortalDocument.builder()
                    .documentName(file.getOriginalFilename())
                    .documentType(file.getContentType())
                    .documentLocation(userDocumentDirectory)
                    .dateAdded(LocalDate.now())
                    .build();
            file.transferTo(new File(userDocumentDirectory));
            this.repository.save(document);
        }catch (IOException exception)
        {
            log.error("Save request:{}", exception);
        }
        return document;
    }

    @Override
    public Optional<GraduatePortalDocument> read(Long documentId)
    {
        try{
            GraduatePortalDocument localInstance = this.repository.findById(documentId).get();
            byte[] documentBinData = Files.readAllBytes(new File(localInstance.getDocumentLocation()).toPath());
            document = GraduatePortalDocument.builder()
                    .documentName(localInstance.getDocumentName())
                    .documentType(localInstance.getDocumentType())
                    .documentLocation(localInstance.getDocumentLocation())
                    .documentData(documentBinData)
                    .dateAdded(LocalDate.now())
                    .build();
        }
        catch(IOException exception)
        {
            log.error("Read file bytes:{}", exception);
        }
        return Optional.ofNullable(document);
    }

    /**
     * Returns a list of document's information but NOT the actual
     * document.
     * */
    @Override
    public List<GraduatePortalDocument> findAll()
    {
        return repository.findAll();
    }

    /**
     * Returns a list of files/documents.
     * */
    @Override
    public List<byte[]> findAllDocuments()
    {
        List<GraduatePortalDocument> localDocuments = repository.findAll();
        List<byte[]> documentsData = new ArrayList<>();
        localDocuments.forEach(x -> documentsData.add(x.getDocumentData()));
        return documentsData;
    }

    @Override
    public void delete(GraduatePortalDocument object)
    { throw new UnsupportedOperationException(); }
}
