package za.ac.cput.serviceFacade;

import io.jsonwebtoken.Jwts;
import za.ac.cput.exception.NotRegisteredUserException;
import za.ac.cput.exception.PasswordMismatchException;
import za.ac.cput.factory.GraduateFactory;
import za.ac.cput.factory.RecruiterFactory;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.Recruiter;
import za.ac.cput.security.Security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


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
    public static Recruiter validateUserCredentials(Boolean doesUserExist, Recruiter userToValidate, Recruiter existingUser) throws NotRegisteredUserException, PasswordMismatchException
    {
        if(!doesUserExist) return null;
        authenticateUsername(userToValidate.getEmail(), existingUser.getEmail());
        authenticateUserPassword(userToValidate.getPassword(), existingUser.getPassword());

        return RecruiterFactory.build(existingUser.getFirstName(),
                                      existingUser.getSurname(),
                                      existingUser.getCompanyName(),
                                      existingUser.getEmail(),
                                      existingUser.getCellphone(),
                                      existingUser.getPassword(),
                                      existingUser.getVacancies(),
                                      existingUser.getUserRole(),
                                      existingUser.getDateAdded());
    }

    /**
     * @param doesUserExist
     * @param existingUser
     * @param userToValidate
     * */
    public static Graduate validateUserCredentials(Boolean doesUserExist, Graduate userToValidate, Graduate existingUser) throws NotRegisteredUserException, PasswordMismatchException
    {
        if(!doesUserExist) return null;
        authenticateUsername(userToValidate.getEmail(), existingUser.getEmail());
        authenticateUserPassword(userToValidate.getPassword(), existingUser.getPassword());

        return GraduateFactory.build(existingUser.getFirstName(),
                                     existingUser.getPreferredName(),
                                     existingUser.getSurname(),
                                     existingUser.getEmail(),
                                     existingUser.getSecondaryEmail(),
                                     existingUser.getPassword(),
                                     existingUser.getCellphone(),
                                     existingUser.getUserRole(),
                                     existingUser.getCv(),
                                     existingUser.getQualifications(),
                                     existingUser.getExperiences());
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

    private static void authenticateUserPassword(String userToValidate, String existingUser) throws PasswordMismatchException
    {
        if(!hashPassword(userToValidate).equals(existingUser))
            throw new PasswordMismatchException();
    }

    private static void authenticateUsername(String userToValidate, String existingUser) throws NotRegisteredUserException
    {
        if(!userToValidate.equalsIgnoreCase(existingUser))
            throw new NotRegisteredUserException();
    }

    private static String hashPassword(String password)
    {
        return Security.bCryptPasswordEncoder().encode(password);
    }
}
