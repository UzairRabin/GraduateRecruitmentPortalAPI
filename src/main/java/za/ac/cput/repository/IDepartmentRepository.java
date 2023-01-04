package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.model.Department;

import java.util.Optional;

/**
 * @author Chadrack Mbuyi
 * */

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, String> {

}
