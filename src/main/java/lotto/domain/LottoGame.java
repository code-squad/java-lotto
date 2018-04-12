package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class LottoGame {
    private LottoGenerator lottoGenerator;
    private List<Lotto> lottos;

    public LottoGame(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> generateLottos(int money) {
        lottos = lottoGenerator.generate(getLottoNumber(money));
        return lottos;
    }

    public double calculateProfitRate(LottoWinNumbers winNumbers, int money) {
        return sumPrize(winNumbers) / money * 100;
    }

    public Map<LottoWinType, Long> getResults(LottoWinNumbers winNumbers) {
        Map<LottoWinType, Long> winResults = getWinResults(winNumbers);

        Arrays.stream(LottoWinType.values())
                .filter(lottoWinType -> !winResults.containsKey(lottoWinType))
                .forEach(lottoWinType -> winResults.put(lottoWinType, 0l));
        return winResults;
    }
    
    private Map<LottoWinType, Long> getWinResults(LottoWinNumbers winNumbers) {
        return lottos.stream()
                .collect(groupingBy(lotto -> lotto.getWinType(winNumbers), counting()));
    }
    
    private int getLottoNumber(int money) {
        return money / Lotto.LOTTO_PRICE;
    }

    private double sumPrize(LottoWinNumbers winNumbers) {
        return lottos.stream()
                .mapToInt(lotto -> lotto.getWinType(winNumbers).getPrize())
                .sum();
    }
}
