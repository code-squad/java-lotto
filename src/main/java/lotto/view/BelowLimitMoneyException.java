package lotto.view;

public class BelowLimitMoneyException extends RuntimeException{
    public BelowLimitMoneyException(String message) {
        super(message);
    }
}
