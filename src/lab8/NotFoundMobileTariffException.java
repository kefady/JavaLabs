package lab8;

public class NotFoundMobileTariffException extends Exception{
    public NotFoundMobileTariffException() {
        super();
    }

    public NotFoundMobileTariffException(String message) {
        super(message);
    }

    public NotFoundMobileTariffException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundMobileTariffException(Throwable cause) {
        super(cause);
    }
}
