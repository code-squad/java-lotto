package lotto.domain;

import lotto.domain.enums.LottoCorrectCount;
import lotto.dto.LottoResult;

import java.util.List;
import java.util.Map;

public class LottoResults {
    private List<LottoResult> lottoResults;

    private LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults generate(List<LottoResult> lottoResults) {
        return new LottoResults(lottoResults);
    }

    public static int getProfit(Map<LottoCorrectCount, Integer> resultMap) {
        return resultMap.entrySet().stream()
                .mapToInt(map -> map.getKey().getProfit() * map.getValue())
                .sum();
    }

    public static float getProfitRate(int totalProfit, int money) {
        return (float) totalProfit * 100 / (float) money;
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }
}
