package lab8;

public class NoMoreCustomersException extends Exception {
    public NoMoreCustomersException() {
        super();
    }

    public NoMoreCustomersException(String message) {
        super(message);
    }

    public NoMoreCustomersException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMoreCustomersException(Throwable cause) {
        super(cause);
    }
}
