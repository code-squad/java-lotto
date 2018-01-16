package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumCreator implements LottoNumberCreationStrategy {
    public static final int LOTTO_POOL_NUM = 6;
    public static final int LOTTO_POOL_MAX_NUM = 45;

    @Override
    public List<LottoNo> createLottoNums() {
        return getSubNums(shuffleNums(createNums()));
    }

    private List<LottoNo> createNums() {
        List<LottoNo> nums = new ArrayList<>(LOTTO_POOL_MAX_NUM);
        for (int i = 1; i <= LOTTO_POOL_MAX_NUM; i++)
            nums.add(new LottoNo(i));

        return nums;
    }

    private List<LottoNo> shuffleNums(List<LottoNo> nums) {
        Collections.shuffle(nums);

        return nums;
    }

    private List<LottoNo> getSubNums(List<LottoNo> nums) {
        return nums.subList(0, LOTTO_POOL_NUM);
    }
}
