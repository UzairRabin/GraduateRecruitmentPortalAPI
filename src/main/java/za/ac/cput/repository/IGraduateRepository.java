package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.model.Graduate;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 24 November 2022
 */

@Repository
public interface IGraduateRepository extends JpaRepository<Graduate, String> {

}
