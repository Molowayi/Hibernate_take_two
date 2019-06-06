package be.intecbrussel.dakplusplus.datalayer;

public class BadMethodCallException extends Exception {

    public BadMethodCallException() {
    }

    public BadMethodCallException(String message) {
        super(message);
    }

    public BadMethodCallException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadMethodCallException(Throwable cause) {
        super(cause);
    }
}
