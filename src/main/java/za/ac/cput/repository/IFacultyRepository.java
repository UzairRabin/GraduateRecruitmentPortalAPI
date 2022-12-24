package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.model.Faculty;

public interface IFacultyRepository extends JpaRepository<Faculty, Long> {
}
