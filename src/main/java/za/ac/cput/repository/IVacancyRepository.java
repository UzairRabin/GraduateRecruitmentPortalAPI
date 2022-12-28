package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.model.Vacancy;

/**
 * @author Mbuso Kotobe
 * */
public interface IVacancyRepository extends JpaRepository<Vacancy, Long> {
}
