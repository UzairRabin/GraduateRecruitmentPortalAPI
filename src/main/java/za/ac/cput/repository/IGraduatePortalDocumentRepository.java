package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.factory.GraduatePortalDocumentFactory;
import za.ac.cput.model.GraduatePortalDocument;

public interface IGraduatePortalDocumentRepository extends JpaRepository<GraduatePortalDocument, Long> {
}
