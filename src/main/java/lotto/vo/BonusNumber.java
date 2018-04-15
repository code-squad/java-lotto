package lotto.vo;

public class BonusNumber {
    private int number;

    private BonusNumber(int number) {
        if(!LottoNumber.isLottoNumber(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public static BonusNumber of(int number) {
        return new BonusNumber(number);
    }

    int toInt() {
        return number;
    }
}
