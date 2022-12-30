package za.ac.cput.serviceFacade;

import io.jsonwebtoken.Jwts;
import za.ac.cput.exception.NotRegisteredUserException;
import za.ac.cput.exception.PasswordMismatchException;
import za.ac.cput.exception.UserExistsException;
import za.ac.cput.factory.GraduateFactory;
import za.ac.cput.factory.RecruiterFactory;
import za.ac.cput.factory.UserSessionFactory;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.Recruiter;
import za.ac.cput.model.UserSession;
import za.ac.cput.security.Security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;


/**
 * @author Mbuso Kotobe
 *
 * */
public class UserAuthenticatorServiceFacadeImpl {

    /**
     * @param doesUserExist
     * @param existingUser
     * @param userToValidate
     * */
    public static UserSession validateUserCredentials(Boolean doesUserExist, Recruiter userToValidate, Recruiter existingUser) throws NotRegisteredUserException, PasswordMismatchException
    {
        if(!doesUserExist) return null;
        authenticateUsername(userToValidate.getEmail(), existingUser.getEmail());
        authenticateUserPassword(userToValidate.getPassword(), existingUser.getPassword());
        return UserSessionFactory.build(generateSessionToken(existingUser), existingUser.getUserId());
    }

    /**
     * @param doesUserExist
     * @param existingUser
     * @param userToValidate
     * */
    public static UserSession validateUserCredentials(Boolean doesUserExist, Graduate userToValidate, Graduate existingUser) throws NotRegisteredUserException, PasswordMismatchException
    {
        if(!doesUserExist) return null;
        authenticateUsername(userToValidate.getEmail(), existingUser.getEmail());
        authenticateUserPassword(userToValidate.getPassword(), existingUser.getPassword());
        return UserSessionFactory.build(generateSessionToken(existingUser), existingUser.getUserId());
    }

    public static void checkUserExists(Optional<Graduate> graduate) throws UserExistsException
    {
        if(graduate.isPresent())
            throw new UserExistsException();
    }

    public static String generateSessionToken(Recruiter recruiter)
    {
        return Jwts.builder()
                .claim("name", recruiter.getFirstName() + " " + recruiter.getSurname())
                .claim("email", recruiter.getEmail())
                .setSubject(recruiter.getFirstName())
                .setId(recruiter.getUserId().toString())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(12L, ChronoUnit.HOURS)))
                .compact();
    }

    public static String generateSessionToken(Graduate graduate)
    {
        return Jwts.builder()
                .claim("name", graduate.getFirstName() + " " + graduate.getSurname())
                .claim("email", graduate.getEmail())
                .setSubject(graduate.getFirstName())
                .setId(graduate.getUserId().toString())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(12L, ChronoUnit.HOURS)))
                .compact();
    }

    public static String hashPassword(String password)
    {
        return Security.bCryptPasswordEncoder().encode(password);
    }

    private static void authenticateUserPassword(String userPasswordToValidate, String existingUserPassword) throws PasswordMismatchException
    {
        if(!Security.bCryptPasswordEncoder().matches(userPasswordToValidate, existingUserPassword))
            throw new PasswordMismatchException();
    }

    private static void authenticateUsername(String userToValidate, String existingUser) throws NotRegisteredUserException
    {
        if(!userToValidate.equalsIgnoreCase(existingUser))
            throw new NotRegisteredUserException();
    }
}