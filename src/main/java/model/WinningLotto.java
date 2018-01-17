package model;

import dto.LottoResult;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
public class WinningLotto {
    private static final Integer LOTTO_PRICE = 1000;

    private List<Integer> winningNumbers;
    private Integer bonusNum;

    public WinningLotto(Lotto lotto, Integer bonusNum) {
        this.winningNumbers = lotto.getNumbers();
        this.bonusNum = bonusNum;
    }

    public Rank compare(Lotto lotto) {
        Integer hit = 0;

        for (Integer one : lotto.getNumbers()) {
            if (winningNumbers.contains(one)) {
                hit++;
            }
        }

        return convertFromHitNumsToRank(lotto, hit);
    }

    public Rank convertFromHitNumsToRank(Lotto lotto, Integer hitNumber) {
        Rank rank = null;

        List<Integer> filterNumber = Arrays.asList(3, 4, 5, 6);
        for (Integer integer : filterNumber) {
            if (hitNumber.equals(integer)){
                rank = Rank.valueOf(integer, false);
            }
        }

        if(hitNumber.equals(5) && lotto.getNumbers().contains(bonusNum)) {
            rank = Rank.valueOf(5, true);
        }

        return rank;
    }

    public LottoResult match(List<Lotto> lottos, Map<Lotto, Rank> lottoRankMap){
        Map<Rank, Integer> winningLottoByRank = LottoMapStrategy.combinedByRank(lottoRankMap);
        Double percentage = analyze(lottos, winningLottoByRank);

        LottoResult lottoResult = new LottoResult(LottoMapStrategy.sortMap(winningLottoByRank), percentage);
        return lottoResult;
    }


    public Double analyze(List<Lotto> lottos, Map<Rank, Integer> winningLottoByRank) {
        Integer loseAmount = calculateLoseAmount(lottos);
        Integer profit = calculateProfit(winningLottoByRank);

        return (double)(profit - loseAmount) / (double)loseAmount * 100;
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
