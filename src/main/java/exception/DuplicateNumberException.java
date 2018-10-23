package exception;

public class DuplicateNumberException extends RuntimeException {

    public DuplicateNumberException() {
        super();
    }

    public DuplicateNumberException(String message) {
        super(message);
    }

}
