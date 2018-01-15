package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.enums.LottoCorrectCount;
import lotto.domain.lottogenerator.LottoNumberGenerator;
import lotto.dto.LottoResult;

public class LottoResults {
    private List<LottoResult> lottoResults;

    private LottoResults(List<Lotto> lottos, LottoNumberGenerator lottoNumberGenerator) {
        lottoResults = generateFinalResult(lottos, lottoNumberGenerator);
    }

    public static LottoResults generateLottoResults(List<Lotto> lottos, LottoNumberGenerator lottoNumberGenerator) {
        return new LottoResults(lottos, lottoNumberGenerator);
    }

    private static List<LottoResult> generateFinalResult(List<Lotto> lottos, LottoNumberGenerator lottoNumberGenerator) {
        return lottos.stream()
                .map(lotto -> new LottoResult(lotto.getCorrectCount(lottoNumberGenerator.generate())))
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
