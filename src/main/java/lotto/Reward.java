package lotto;

import java.util.*;

public class Reward {
    private Map<Integer, Integer> map = new HashMap<>();

    public Map<Integer, Integer> lottoRewardCount() {
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        return map;
    }

    public Map<Integer, Integer> lottoPrice() {
        map.put(3, 5000);
        map.put(4, 50000);
        map.put(5, 1500000);
        map.put(6, 2000000000);
        return map;
    }

    public double earningRate(Map<Integer, Integer> lottoRewardCount) {
        double rewardPrice = 0;
        for (Integer integer : map.keySet()) {
            rewardPrice += lottoPrice().get(integer) * lottoRewardCount.get(integer);
        }
        return rewardPrice;
    }
}
