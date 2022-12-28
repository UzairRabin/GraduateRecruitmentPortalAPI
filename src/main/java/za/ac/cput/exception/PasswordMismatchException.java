package za.ac.cput.exception;

/**
 * @author Mbuso Kotobe
 * */
public class PasswordMismatchException extends Exception{
    String message;

    public PasswordMismatchException()
    {
        super("Access denied, passwords do not match!");
    }

    public PasswordMismatchException(String message)
    {
        super(message);
    }
}
