package domain;

public class InputLottoNumberException extends RuntimeException {
    /* LottoNum을 잘못입력했을 경우 발생하는 예외 */
    InputLottoNumberException(String msg) {
        super(msg);
    }
}
