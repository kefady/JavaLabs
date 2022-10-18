package lab8;

public class NotFoundMatches extends Exception{
    public NotFoundMatches() {
        super();
    }

    public NotFoundMatches(String message) {
        super(message);
    }

    public NotFoundMatches(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundMatches(Throwable cause) {
        super(cause);
    }
}
