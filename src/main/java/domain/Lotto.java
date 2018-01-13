package domain;

import java.util.List;

public class Lotto {
    private List<Integer> nums;

    Lotto(LottoNumberCreationStrategy lottoNumCreator) {
        nums = lottoNumCreator.createLottoNums();
    }

    @Override
    public String toString() {
        return nums.toString();
    }
}
