package domain;

public class InputLottoException extends RuntimeException{
    /* 당첨번호와 수동번호 잘못 입력했을 경우, 발생시키는 예외 */
    InputLottoException(String msg) {
        super(msg);
    }
}
