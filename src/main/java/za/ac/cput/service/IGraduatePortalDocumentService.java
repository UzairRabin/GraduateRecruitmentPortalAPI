package za.ac.cput.service;

import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.model.GraduatePortalDocument;
import za.ac.cput.repository.IGraduatePortalDocumentRepository;

import java.util.List;

public interface IGraduatePortalDocumentService extends IService<GraduatePortalDocument, Long>
{
    GraduatePortalDocument save(MultipartFile document, Long userId);
    List<byte[]> findAllDocuments();
}
