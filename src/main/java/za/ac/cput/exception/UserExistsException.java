package za.ac.cput.exception;

public class UserExistsException extends Exception{
    private String message;

    public UserExistsException()
    {
        super("User is already registered.");
    }

    public UserExistsException(String message)
    {
        super(message);
    }
}
