package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.counting;

public class LottoGame {
    private LottoGenerator lottoGenerator;
    private List<Lotto> lottos;

    public LottoGame(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> generateLottos(int money) {
        lottos = lottoGenerator.generate(getLottoNumer(money));
        return lottos;
    }

    public double calculateProfitRate(Numbers winNumbers, int money) {
        return sumPrize(winNumbers) / money * 100;
    }

    public Map<LottoWinType, Long> getResults(Numbers winNumbers) {
        Map<LottoWinType, Long> winResults = getWinResults(winNumbers);

        Arrays.stream(LottoWinType.values())
                .filter(lottoWinType -> !winResults.containsKey(lottoWinType))
                .forEach(lottoWinType -> winResults.put(lottoWinType, 0l));
        return winResults;
    }

    private Map<LottoWinType, Long> getWinResults(Numbers winNumbers) {
        Map<LottoWinType, Long> winResults = lottos.stream()
                .map(lotto -> lotto.countMatchNumbers(winNumbers))
                .filter(matchCount -> LottoWinType.contains(matchCount))
                .collect(groupingBy(matchCount -> LottoWinType.valueOf(matchCount), counting()));

        return winResults;
    }

    private int getLottoNumer(int money) {
        return money / Lotto.LOTTO_PRICE;
    }

    private double sumPrize(Numbers winNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.countMatchNumbers(winNumbers))
                .filter(matchCount -> LottoWinType.contains(matchCount))
                .mapToInt(matchCount -> LottoWinType.valueOf(matchCount).getPrize())
                .sum();
    }
}
