package za.ac.cput.service;

import za.ac.cput.model.Graduate;

import java.util.Optional;
import java.util.Set;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 24 November 2022
 */
public interface IGraduateService extends IService<Graduate, Long>
{
    void deleteById(Long graduateId);
    Optional<Graduate> findGraduateByEmail(String email);
}

