package lotto;

import lotto.vo.BonusNumber;
import lotto.vo.LottoNumber;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private LottoNumber lottoNumber;

    private Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    static Lotto of() {
        return new Lotto(LottoNumber.of());
    }

    static Lotto of(LottoNumber lottoNumber) {
        return new Lotto(lottoNumber);
    }

    static Lotto of(List<Integer> numbers) {
        return new Lotto(LottoNumber.of(numbers));
    }

    int matchCount(Lotto winLotto) {
        return lottoNumber.matchCount(winLotto.lottoNumber);
    }

    boolean matchBonus(BonusNumber bonusNumber) {
        return lottoNumber.matchBonus(bonusNumber);
    }

    @Override
    public String toString() {
        return this.lottoNumber.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return lottoNumber.equals(that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
