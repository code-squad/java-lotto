package model;

import DTO.LottoResult;
import DTO.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private static final Integer LOTTO_PRICE = 1000;

    private List<Lotto> lottos = new ArrayList();

    public List<Lotto> buy(Integer amount) {
        Integer number = amount / LOTTO_PRICE;

        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(RandomNumber.shuffleNumber()));
        }

        return lottos;
    }

    public Map<Lotto, Integer> getHitNumbers(String result) {
        Map<Lotto, Integer> hitnumberForEachLottos = new HashMap();

        for (Lotto lotto : lottos) {
            List<Integer> lastWeekResultNumbers = getResultValue(result);
            hitnumberForEachLottos.put(lotto, lotto.compare(lastWeekResultNumbers));
        }

        return hitnumberForEachLottos;
    }

    private List<Integer> getResultValue(String result) {
        List<Integer> resultNumbers = new ArrayList();
        for (String value : result.split(",")) {
            resultNumbers.add(Integer.parseInt(value));
        }
        return resultNumbers;
    }

    public Double analyze(Map<Rank, Integer> winningLottoByRank) {
        Integer loseAmount = calculateLoseAmount();
        Integer profit = calculateProfit(winningLottoByRank);

        return (double)(profit - loseAmount) / (double)loseAmount * 100;
    }

    private Integer calculateLoseAmount() {
        return lottos.size() * LOTTO_PRICE;
    }

    private Integer calculateProfit(Map<Rank, Integer> winningLottoByRank) {
        Integer sum = 0;

        for (Rank rank : winningLottoByRank.keySet()) {
            sum += winningLottoByRank.get(rank) * rank.getWinningMoney();
        }

        return sum;
    }

    public WinningLotto convertFromHitNumsToRank(Map<Lotto, Integer> hitNumbersForEachLotto, Integer bonusNum) {
        Rank rank;
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> filterNumber = Arrays.asList(3, 4, 5, 6);

        for (Lotto lotto : hitNumbersForEachLotto.keySet()) {
            for (Integer integer : filterNumber) {
                if (hitNumbersForEachLotto.get(lotto).equals(integer)){
                    rank = Rank.valueOf(integer, false);
                    winningLotto.putWinningLotto(lotto, rank);
                }
            }
        }
        winningLotto = filterForBonusRank(hitNumbersForEachLotto, bonusNum, winningLotto);

        return winningLotto;
    }

    private WinningLotto filterForBonusRank(Map<Lotto, Integer> hitNumbersForEachLotto, Integer bonusNum, WinningLotto winningLotto) {
        for (Lotto lotto : hitNumbersForEachLotto.keySet()){
            if (hitNumbersForEachLotto.get(lotto).equals(5)){
                if (lotto.getNumbers().contains(bonusNum)){
                    winningLotto.getWinningLotto().remove(lotto);
                    Rank rank = Rank.valueOf(5, true);
                    winningLotto.putWinningLotto(lotto, rank);
                }
            }
        }
        return winningLotto;
    }

    public LottoResult match(String result, Integer bonusNum){
        Map<Lotto, Integer> hitNumbersForEachLotto = getHitNumbers(result);
        WinningLotto winningLotto = convertFromHitNumsToRank(hitNumbersForEachLotto, bonusNum);

        Map<Rank, Integer> winningLottoByRank = combinedByRankFromWinningLotto(winningLotto);
        Double percentage = analyze(winningLottoByRank);

        LottoResult lottoResult = new LottoResult(LottoMapStrategy.sortMap(winningLottoByRank), percentage);
        return lottoResult;
    }

    private Map<Rank, Integer> combinedByRankFromWinningLotto(WinningLotto winningLotto) {
        Map<Lotto, Rank> winningLottos = winningLotto.getWinningLotto();
        Map<Rank, Integer> result = new LinkedHashMap();

        for (Lotto lotto : winningLottos.keySet()) {
            Integer count = 1;
            if (result.keySet().contains(winningLottos.get(lotto))) {
                count = result.get(winningLottos.get(lotto)) + 1;
                result.remove(winningLottos.get(lotto));
            }
            result.put(winningLottos.get(lotto), count);
        }

        for (Rank rank : Rank.values()) {
            if (!result.keySet().contains(rank)){
                result.put(rank, 0);
            }
        }

        return result;
    }
}
