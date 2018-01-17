package lotto.domain;

import java.math.BigInteger;
import java.util.Map;

public class LottoResult {
    public static final String MESSAGE_HEADER = "당첨 통계";
    public static final String MESSAGE_HEADER_LINE = "---------";
    private static final BigInteger HUNDRED_BIG_INTEGER = new BigInteger("100");
    private static final int HUNDRED = 100;

    private final Map<LottoPrize, Integer> lottoPrizeResults;
    private final BigInteger ticketTotalPrice;

    public LottoResult(Map<LottoPrize, Integer> lottoPrizeResults, int ticketTotalPrice) {
        this.lottoPrizeResults = lottoPrizeResults;
        this.ticketTotalPrice = new BigInteger(String.valueOf(ticketTotalPrice));
    }

    public int getPrizeCount(LottoPrize lottoPrize) {
        Integer count = lottoPrizeResults.get(lottoPrize);
        return (count == null) ? 0 : count;
    }

    public int calculateProfitRatio() {
        int ratio = calculateTotalProfit().multiply(HUNDRED_BIG_INTEGER).divide(ticketTotalPrice).intValue();
        if (ratio < HUNDRED) {
            return (HUNDRED - ratio) * -1;
        }
        return ratio;
    }

    private BigInteger calculateTotalProfit() {
        BigInteger totalProfit = BigInteger.ZERO;
        for (LottoPrize lottoPrize : lottoPrizeResults.keySet()) {
            BigInteger amount = new BigInteger(String.valueOf(lottoPrize.getPrizeAmount()));
            BigInteger count = new BigInteger(String.valueOf(lottoPrizeResults.get(lottoPrize)));
            totalProfit = totalProfit.add(amount.multiply(count));
        }
        return totalProfit;
    }

    public String showResultMessage(LottoPrize prize) {
        return prize.showMessage() +
                "- " +
                lottoPrizeResults.get(prize) +
                "개";
    }

    public String showProfitRatioResultMessage() {
        return "총 수익률은 " + this.calculateProfitRatio() + "%입니다";
    }
}
