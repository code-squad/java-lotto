package lotto;

public class WrongAmountException extends RuntimeException {

    public WrongAmountException(String message){
        super(message);
    }
}
