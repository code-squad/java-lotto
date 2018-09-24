package Lotto.Exception;

public class ManualPurchaseLessThanZeroException extends IllegalArgumentException {

    public ManualPurchaseLessThanZeroException() {
        super("구매 개수가 0이하일 수 없습니다.");
    }

}
