package lotto.domain;

public class LottoNo {

    private Integer number;

    public LottoNo (Integer number) {
        if (isNotLottoNumber(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    private boolean isNotLottoNumber(Integer number) {
        return number == null || number < 1 || number > 45;
    }
}

