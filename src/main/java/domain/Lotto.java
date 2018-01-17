package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static domain.LottoNumCreator.LOTTO_POOL_NUM;

public class Lotto {
    private List<LottoNo> lottoNos;

    public Lotto(List<Integer> lottoNos) {
        this.lottoNos = integerToLottoNo(lottoNos);
    }

    private List<LottoNo> integerToLottoNo(List<Integer> nos) {
        List<LottoNo> lottoNos = new ArrayList<>(nos.size());
        for(int no : nos)
            lottoNos.add(new LottoNo(no));

        return lottoNos;
    }

    public int howManyCorrespond(Lotto winningNumber) {
        return correspondNums(winningNumber).size();
    }

    public List<LottoNo> correspondNums(Lotto winnigNumber) {
        List<LottoNo> correspondNums = new ArrayList<>(LOTTO_POOL_NUM);

        for (int i = 0 ; i < winnigNumber.lottoNos.size() ; i++)
            checkCorrespond(correspondNums, winnigNumber.lottoNos.get(i));

        return correspondNums;
    }

    private void checkCorrespond(List<LottoNo> correspondNums, LottoNo targetNum) {
        if(lottoNos.contains(targetNum))
            correspondNums.add(targetNum);
    }

    public boolean isBonusNumMatch(LottoNo bonusNum) {
        return lottoNos.contains(bonusNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNos, lotto.lottoNos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lottoNos);
    }

    @Override
    public String toString() {
        return lottoNos.toString();
    }
}
