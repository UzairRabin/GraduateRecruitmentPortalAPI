/*
Author: Tiffany Kiwiets
Repository for Cv
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.model.Cv;


@Repository
public interface ICvRepository extends JpaRepository<Cv, String> {

}
