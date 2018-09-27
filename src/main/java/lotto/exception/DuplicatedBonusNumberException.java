package lotto.exception;

public class DuplicatedBonusNumberException extends IllegalArgumentException {

    public DuplicatedBonusNumberException() {
        super("보너스 번호가 중복되었습니다.");
    }

}
