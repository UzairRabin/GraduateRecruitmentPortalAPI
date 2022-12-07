package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.model.Vacancy;

public interface IVacancyRepository extends JpaRepository<Vacancy, Long> {
}
