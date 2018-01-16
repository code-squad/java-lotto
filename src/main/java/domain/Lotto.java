package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static domain.LottoNumCreator.LOTTO_POOL_NUM;

public class Lotto {
    private List<LottoNo> nums;

    public Lotto(LottoNumberCreationStrategy lottoNumCreator) {
        nums = lottoNumCreator.createLottoNums();
    }

    public int howManyCorrespond(List<LottoNo> winningNumber) {
        return correspondNums(winningNumber).size();
    }

    public List<LottoNo> correspondNums(List<LottoNo> winnigNumber) {
        List<LottoNo> correspondNums = new ArrayList<>(LOTTO_POOL_NUM);

        for (int i = 0 ; i < winnigNumber.size() ; i++)
            checkCorrespond(correspondNums, winnigNumber.get(i));

        return correspondNums;
    }

    private void checkCorrespond(List<LottoNo> correspondNums, LottoNo targetNum) {
        if(nums.contains(targetNum))
            correspondNums.add(targetNum);
    }

    public boolean isBonusNumMatch(LottoNo bonusNum) {
        return nums.contains(bonusNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(nums, lotto.nums);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nums);
    }

    @Override
    public String toString() {
        return nums.toString();
    }
}
