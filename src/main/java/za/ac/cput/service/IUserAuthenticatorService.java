package za.ac.cput.service;

import za.ac.cput.exception.NotRegisteredUserException;
import za.ac.cput.exception.PasswordMismatchException;

/**
 * @author Mbuso Kotobe
 *
 * */
public interface IUserAuthenticatorService<T> {
    T login(T user) throws NotRegisteredUserException, PasswordMismatchException;
}
