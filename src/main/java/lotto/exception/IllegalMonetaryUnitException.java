package lotto.exception;

public class IllegalMonetaryUnitException extends IllegalArgumentException {

    public IllegalMonetaryUnitException() {
        super("구매 단위가 잘못되었습니다.");
    }

}
