package lotto;

import money.Money;
import rank.Decision;
import rank.Rank;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private int profit;
    private HashMap<Rank, Integer> finalCount;
    private List<Lotto> lottos;

    Money money = new Money();
    Decision decision = new Decision();

    public int getProfit(List<Lotto> lottos, WinningLotto winningNumber, String bonusNumber) {
        int inputMoney = lottos.size() * 1000;
        int profit = money.profit(money.totalMoney(decision.decisionRank(lottos, winningNumber.getWinningLotto(), bonusNumber)), inputMoney);
        return profit;
    }

    public HashMap<Rank, Integer> resultCount(WinningLotto winningLotto, List<Lotto> lottos) {
        HashMap<Rank, Integer> resultCount = money.money(decision.decisionRank(lottos, winningLotto.getWinningLotto(), winningLotto.getBonusNum()));
        return resultCount;
    }

    public List<Lotto> getLottos() {
        LottoGame lottoGame = new LottoGame();
        lottos = lottoGame.getLottos();
        return lottos;
    }

    public int getFirst() {
        return finalCount.get(Rank.FIRST);
    }

    public int getSecond() {
        return finalCount.get(Rank.SECOND);
    }

    public int getThird() {
        return finalCount.get(Rank.THIRD);
    }

    public int getFourth() {
        return finalCount.get(Rank.FOURTH);
    }

    public int getFifth() {
        return finalCount.get(Rank.FIFTH);
    }
}
