package lotto.domain;

public enum LottoPrize {
    /**
     3개 일치 (5000원)- 1개
     4개 일치 (50000원)- 0개
     5개 일치 (1500000원)- 0개
     6개 일치 (2000000000원)- 0개
     */
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    NONE(0, 0);

    private int successCount;
    private int prizeAmount;

    LottoPrize(int successCount, int prizeAmount) {
        this.successCount = successCount;
        this.prizeAmount = prizeAmount;
    }

    public static LottoPrize letMeKnowPrize(int matchCount) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize.isMatch(matchCount)) {
                return lottoPrize;
            }
        }
        return LottoPrize.NONE;
    }

    public boolean isMatch(int matchCount) {
        return this.successCount == matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getSuccessCount() {
        return successCount;
    }
}
