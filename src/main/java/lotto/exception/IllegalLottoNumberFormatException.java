package lotto.exception;

public class IllegalLottoNumberFormatException extends IllegalArgumentException {

    public IllegalLottoNumberFormatException() {
        super("로또 형식이 잘못되었습니다.");
    }

}
