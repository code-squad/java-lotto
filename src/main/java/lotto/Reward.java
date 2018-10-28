package lotto;

import java.util.*;

public class Reward {
    private final int MAX_MATCH_COUNT = 6;
    private final int MIN_MATCH_COUNT = 3;
    private Map<Integer, Integer> map = new HashMap<>();

    public Map<Integer, Integer> lottoRewardCount() {
        int[] initMatchCount = {0, 0, 0, 0};
        forStatement(initMatchCount);
        return map;
    }

    public Map<Integer, Integer> lottoPrice() {
        int[] priceManager = {5000, 50000, 1500000, 2000000000};
        forStatement(priceManager);
        return map;
    }

    public void forStatement(int[] values) {
        for (int i = MIN_MATCH_COUNT; i <= MAX_MATCH_COUNT; i++) {
            map.put(i, values[i - MIN_MATCH_COUNT]);
        }
    }

    public double earningRate(Map<Integer, Integer> lottoRewardCount) {
        double rewardPrice = 0;
        for (Integer integer : map.keySet()) {
            rewardPrice += lottoPrice().get(integer) * lottoRewardCount.get(integer);
        }
        return rewardPrice;
    }
}
