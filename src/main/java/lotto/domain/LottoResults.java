package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lotto.domain.enums.LottoCorrectCount;
import lotto.dto.LottoResult;

public class LottoResults extends ArrayList<LottoResult> {

    public static int getProfit(Map<LottoCorrectCount, Integer> resultMap) {
        return resultMap.entrySet().stream()
                .mapToInt(map -> map.getKey().getProfit() * map.getValue())
                .sum();
    }

    public static float getProfitRate(int totalProfit, int money) {
        return (float) totalProfit * 100 / (float) money;
    }

    public List<LottoResult> getLottoResults() {
        return this;
    }
}
