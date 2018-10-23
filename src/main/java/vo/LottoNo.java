package vo;

import domain.Lotto;

import java.util.Objects;

public class LottoNo {
    private int number;

    public LottoNo(int number) {
        this.number = isValidNumber(number);
    }

    private int isValidNumber(int number){
        if(number < Lotto.MIN || number > Lotto.MAX) throw new IllegalArgumentException();
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
