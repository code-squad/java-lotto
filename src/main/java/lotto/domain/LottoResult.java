package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class LottoResult {

    Map<Prize, Integer> prizeResult;

    public LottoResult(List<Prize> prizeList) {
        prizeResult = new HashMap<>();
        for (Prize prize : prizeList) {
            addPrize(prize);
        }
    }

    private void addPrize(Prize prize) {
        Integer count = prizeResult.get(prize);
        prizeResult.put(prize, count != null ? count+1 : 1);
    }

    public int getPrizeCount(Prize prize) {
        return prizeResult.getOrDefault(prize, 0);
    }

    public Map<Prize, Integer> getPrizeResult() {
        return Collections.unmodifiableMap(prizeResult);
    }

    public long getTotalReward() {
        return prizeResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }
}
