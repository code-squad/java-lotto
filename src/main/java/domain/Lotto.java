package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.LottoNumCreator.LOTTO_POOL_NUM;

public class Lotto {
    private List<Integer> nums;

    Lotto(LottoNumberCreationStrategy lottoNumCreator) {
        nums = lottoNumCreator.createLottoNums();
    }

    public int howManyCorrespond(List<Integer> winningNumber) {
        return correspondNums(winningNumber).size();
    }

    public List<Integer> correspondNums(List<Integer> winnigNumber) {
        List<Integer> correspondNums = new ArrayList<>(LOTTO_POOL_NUM);

        for (int i = 0 ; i < winnigNumber.size() ; i++)
            checkCorrespond(correspondNums, winnigNumber.get(i));

        return correspondNums;
    }

    private void checkCorrespond(List<Integer> correspondNums, int targetNum) {
        if(nums.contains(targetNum))
            correspondNums.add(targetNum);
    }

    @Override
    public String toString() {
        return nums.toString();
    }
}
