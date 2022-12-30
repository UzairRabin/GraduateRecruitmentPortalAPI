package za.ac.cput.service;

import za.ac.cput.exception.NotRegisteredUserException;
import za.ac.cput.exception.PasswordMismatchException;
import za.ac.cput.model.UserSession;

/**
 * @author Mbuso Kotobe
 *
 * */
public interface IUserAuthenticatorService<T> {
    UserSession login(T user) throws NotRegisteredUserException, PasswordMismatchException;
}
