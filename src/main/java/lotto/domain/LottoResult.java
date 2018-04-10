package lotto.domain;

import java.util.Map;

/**
 * @author sangsik.kim
 */
public class LottoResult {
    private Map<Rank, Integer> result;
    private int buyAmount;

    public LottoResult(Map<Rank, Integer> result, int buyAmount) {
        this.result = result;
        this.buyAmount = buyAmount;
    }

    public int get(Rank winningTier) {
        return this.result.get(winningTier);
    }

    public int getProfitRate() {
        return getTotalAmount() / this.buyAmount * 100;
    }

    private int getTotalAmount() {
        int sum = 0;
        for (Rank tier : result.keySet()) {
            sum += result.get(tier) * tier.getWinningMoney();
        }
        return sum;
    }
}
