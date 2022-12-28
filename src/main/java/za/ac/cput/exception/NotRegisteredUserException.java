package za.ac.cput.exception;

/**
 * @author Mbuso Kotobe
 * */
public class NotRegisteredUserException extends Exception{
    String message;

    public NotRegisteredUserException()
    {
        super("Access denied, user is not recognized");
    }

    public NotRegisteredUserException(String message)
    {
        super(message);
    }
}
