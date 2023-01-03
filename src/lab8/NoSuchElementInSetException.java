package lab8;

import java.util.NoSuchElementException;

public class NoSuchElementInSetException extends NoSuchElementException {
    public NoSuchElementInSetException() {
        super();
    }

    public NoSuchElementInSetException(String s, Throwable cause) {
        super(s, cause);
    }

    public NoSuchElementInSetException(Throwable cause) {
        super(cause);
    }

    public NoSuchElementInSetException(String s) {
        super(s);
    }
}
