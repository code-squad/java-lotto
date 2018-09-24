package Lotto.Exception;

public class OutOfRangeLottoNumberException extends IllegalArgumentException {

    public OutOfRangeLottoNumberException() {
        super("1 부터 45 사이의 숫자를 입력해주세요.");
    }

}
