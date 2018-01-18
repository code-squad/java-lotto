package dto;


import lombok.Getter;
import model.Lotto;
import model.Rank;

import java.util.List;
import java.util.Map;

@Getter
public class LottoResult {
    private static final Integer LOTTO_PRICE = 1000;

    private Map<Rank, Integer> lottoResult;
    private Double percentage;

    public LottoResult(Map<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Double analyze(List<Lotto> lottos) {
        Integer loseAmount = calculateLoseAmount(lottos);
        Integer profit = calculateProfit(lottoResult);

        percentage = (double)(profit - loseAmount) / (double)loseAmount * 100;
        return percentage;
    }

    private Integer calculateLoseAmount(List<Lotto> lottos) {
        return lottos.size() * LOTTO_PRICE;
    }

    private Integer calculateProfit(Map<Rank, Integer> winningLottoByRank) {
        Integer sum = 0;

        for (Rank rank : winningLottoByRank.keySet()) {
            sum += winningLottoByRank.get(rank) * rank.getWinningMoney();
        }

        return sum;
    }
}
