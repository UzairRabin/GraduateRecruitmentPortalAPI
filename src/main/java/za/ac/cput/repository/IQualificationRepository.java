package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.model.Qualification;

@Repository
public interface IQualificationRepository extends JpaRepository<Qualification, String> {
}
