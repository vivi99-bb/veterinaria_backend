package veterinaria.XYZ.exception;

public class ManageException extends Exception{
    public ManageException() {
        super();
    }

    public ManageException(String message) {
        super(message);
    }

    public ManageException(String message, Throwable cause) {
        super(message, cause);
    }



    public ManageException(Throwable cause) {
        super(cause);
    }

    protected ManageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
