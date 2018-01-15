package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.enums.LottoCorrectCount;
import lotto.dto.LottoResult;

public class LottoResults {
    private List<LottoResult> lottoResults;

    private LottoResults(List<Lotto> lottos, List<Integer> winNumbers) {
        lottoResults = generateFinalResult(lottos, winNumbers);
    }

    public static LottoResults generateLottoResults(List<Lotto> lottos, List<Integer> winNumbers) {
        return new LottoResults(lottos, winNumbers);
    }

    private static List<LottoResult> generateFinalResult(List<Lotto> lottos, List<Integer> winNumbers) {
        return lottos.stream()
                .map(lotto -> new LottoResult(lotto.getCorrectCount(winNumbers)))
                .collect(Collectors.toList());
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
