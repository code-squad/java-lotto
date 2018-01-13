package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_POOL_NUM = 6;
    List<Integer> nums;

    Lotto() {
        nums = createNums();
    }

    private List<Integer> createNums() {
        List<Integer> nums = new ArrayList<>(45);
        for (int i = 1; i <= 45; i++)
            nums.add(i);

        Collections.shuffle(nums);

        return nums.subList(0, LOTTO_POOL_NUM);
    }

    @Override
    public String toString() {
        return nums.toString();
    }
}
