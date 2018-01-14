package lotto.domain;

import java.util.Map;

public class LottoResult {
    private static final int HUNDRED = 100;

    private final Map<LottoPrize, Integer> lottoPrizeResults;
    private final int ticketTotalPrice;

    public LottoResult(Map<LottoPrize, Integer> lottoPrizeResults, int ticketTotalPrice) {
        this.lottoPrizeResults = lottoPrizeResults;
        this.ticketTotalPrice = ticketTotalPrice;
    }

    public int getPrizeCount(LottoPrize lottoPrize) {
        Integer count = lottoPrizeResults.get(lottoPrize);
        return (count == null) ? 0 : count;
    }

    public int calculateProfitRatio() {
        int ratio = calculateTotalProfit() * HUNDRED / ticketTotalPrice;
        if (ratio < HUNDRED) {
            return (HUNDRED - ratio) * -1;
        }
        return ratio;
    }

    private int calculateTotalProfit() {
        int totalProfit = 0;
        for (LottoPrize lottoPrize : lottoPrizeResults.keySet()) {
            totalProfit += lottoPrize.getPrizeAmount() * lottoPrizeResults.get(lottoPrize);
        }
        return totalProfit;
    }

    public String showResultMessage(LottoPrize prize) {
        return prize.showMessage() +
                "- " +
                lottoPrizeResults.get(prize) +
                "개";
    }
}
