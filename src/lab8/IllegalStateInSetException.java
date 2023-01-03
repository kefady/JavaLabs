package lab8;

public class IllegalStateInSetException extends IllegalStateException {
    public IllegalStateInSetException() {
        super();
    }

    public IllegalStateInSetException(String s) {
        super(s);
    }

    public IllegalStateInSetException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalStateInSetException(Throwable cause) {
        super(cause);
    }
}
