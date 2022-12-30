package za.ac.cput.service;

import za.ac.cput.exception.NotRegisteredUserException;
import za.ac.cput.exception.PasswordMismatchException;
import za.ac.cput.exception.UserExistsException;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.UserSession;

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
    UserSession login(Graduate user) throws NotRegisteredUserException, PasswordMismatchException;
    Graduate signup(Graduate graduate) throws IllegalArgumentException, UserExistsException;
}

