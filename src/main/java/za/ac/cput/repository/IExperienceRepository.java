package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.model.Experience;

import java.util.Optional;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Long> {
}
