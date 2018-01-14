package lotto.domain;

public enum LottoPrize {
    /**
     3개 일치 (5000원)- 1개
     4개 일치 (50000원)- 0개
     5개 일치 (1500000원)- 0개
     5개 일치, 보너스 볼 일치(30000000원)- 0개
     6개 일치 (2000000000원)- 0개
     */
    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE_BONUS(5, 30000000, true),
    FIVE(5, 1500000, false),
    SIX(6, 2000000000, false),
    NONE(0, 0, false);

    private int successCount;
    private int prizeAmount;
    private boolean isWithBonus;

    LottoPrize(int successCount, int prizeAmount, boolean isWithBonus) {
        this.successCount = successCount;
        this.prizeAmount = prizeAmount;
        this.isWithBonus = isWithBonus;
    }

    public static LottoPrize letMeKnowPrize(int matchCount, boolean isBonusMatch) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize.isMatch(matchCount) && lottoPrize.checkBonus(isBonusMatch)) {
                return lottoPrize;
            }
        }

        return LottoPrize.NONE;
    }

    private boolean checkBonus(boolean isBonusMatch) {
        return !this.isWithBonus || isBonusMatch;
    }

    private boolean isMatch(int matchCount) {
        return this.successCount == matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String showMessage() {
        return this.successCount
                + "개 일치"
                + ((this.isWithBonus) ? ", 보너스 볼 일치" : " ")
                + "(" + this.prizeAmount
                + "원)";
    }
}
