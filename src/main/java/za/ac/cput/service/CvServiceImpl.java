/*
Author: Tiffany Kiwiets
Service class for CV
 */
package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.GraduateRecruitmentPortalAPI;
import za.ac.cput.model.Cv;
import za.ac.cput.repository.ICvRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CvServiceImpl implements ICvService {

    private final ICvRepository repository;
    private Cv cvInstance;

    @Autowired
    public CvServiceImpl(ICvRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cv save(MultipartFile cv, String username)
    {
        try {
            String userCvDirectory = GraduateRecruitmentPortalAPI
                    .getUserDocumentsDirectory(username)
                    .concat("cv").concat("//");

            cvInstance = Cv.builder().documentLocation(userCvDirectory)
                                     .documentName(cv.getOriginalFilename())
                                     .isAcknowledged(false)
                                     .dateAdded(LocalDate.now()).build();
            cv.transferTo(new File(userCvDirectory));
        }catch (IOException | IllegalStateException exception)
        {
            log.error("Save request:{}", cv);
        }
        return cvInstance;
    }

    @Override
    public Cv save(Cv cv)
    {
        throw new NotImplementedException("Use the overload of save(MultipartFile cv, String username)");
    }

    @Override
    public Optional<Cv> read(String s) {
        try{
            Cv cvLocalInstance = this.repository.findById(s).get();
            byte[] cvBinData = Files.readAllBytes(new File(cvInstance.getDocumentLocation()).toPath());
            cvInstance = Cv.builder().documentName(cvLocalInstance.getDocumentName())
                                     .documentLocation(cvLocalInstance.getDocumentLocation())
                                     .isAcknowledged(cvLocalInstance.isAcknowledged())
                                     .cvData(cvBinData)
                                     .dateAdded(cvLocalInstance.getDateAdded()).build();
        }
        catch(IOException exception)
        {
            log.error("Read file bytes:{}", exception);
        }
        return Optional.ofNullable(cvInstance);
    }

    @Override
    public void delete(Cv cv) {
        this.repository.delete(cv);
    }



    @Override
    public List<Cv> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Cv> findAllByUserId()
    {
        return null;
    }

}
