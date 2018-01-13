package lotto.domain;

import java.util.Map;

public class LottoResult {
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
        return calculateTotalProfit() * 100 / ticketTotalPrice;
    }

    private int calculateTotalProfit() {
        int totalProfit = 0;
        for (LottoPrize lottoPrize : lottoPrizeResults.keySet()) {
            totalProfit += lottoPrize.getPrizeAmount() * lottoPrizeResults.get(lottoPrize);
        }
        return totalProfit;
    }

    // 3개 일치 (5000원)- 1개
    public String showResultMessage(LottoPrize prize) {
        StringBuilder sb = new StringBuilder();
        sb.append(prize.getSuccessCount())
                .append("개 일치 (")
                .append(prize.getPrizeAmount())
                .append("원)- ")
                .append(lottoPrizeResults.get(prize))
                .append("개");
        return sb.toString();
    }
}
