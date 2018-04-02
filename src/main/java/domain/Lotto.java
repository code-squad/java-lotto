package domain;

import java.util.Objects;

public class Lotto {

    private LottoNoGroup lottoNoGroup;

    public Lotto() {

    }

    Lotto(LottoNoGroup lottoNoGroup) {
        this.lottoNoGroup = lottoNoGroup;
    }

    public static Lotto of(LottoNoGroup lottoNoGroup) {
        return new Lotto(lottoNoGroup);
    }

    int countMatch(Lotto winninglotto) {
        return lottoNoGroup.countMatch(winninglotto.lottoNoGroup);
    }

    public Rank askRank(WinningLotto winninglotto) {
        return Rank.valueOf(countMatch(winninglotto), winninglotto.isBonus(lottoNoGroup));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNoGroup, lotto.lottoNoGroup);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lottoNoGroup);
    }

    @Override
    public String toString(){
        return lottoNoGroup.toString();
    }
}
