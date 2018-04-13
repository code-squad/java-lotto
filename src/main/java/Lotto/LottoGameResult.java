package Lotto;

public class LottoGameResult {

    private static final int THREE_MATCH_MONEY = 5000;
    private static final int FOUR_MATCH_MONEY = 50000;
    private static final int FIVE_MATCH_MONEY = 1500000;
    private static final int SIX_MATCH_MONEY = 2000000000;

    private static int threeMatchCount = 0;
    private static int fourMatchCount = 0;
    private static int fiveMatchCount = 0;
    private static int sixMatchCount = 0;

    public static void setMatchCount(int matchCount) {
        if (matchCount == 3) {
            threeMatchCount++;
        } else if (matchCount == 4) {
            fourMatchCount++;
        } else if (matchCount == 5) {
            fiveMatchCount++;
        } else if (matchCount == 6) {
            sixMatchCount++;
        }
    }

    public static int getThreeMatchCount() {
        return threeMatchCount;
    }

    public static int getFourMatchCount() {
        return fourMatchCount;
    }

    public static int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public static int getSixMatchCount() {
        return sixMatchCount;
    }

    public static int getYield(int money) {
        return Math.round(totalYieldMoney() / money * 100);
    }

    private static float totalYieldMoney() {
        return THREE_MATCH_MONEY * threeMatchCount + FOUR_MATCH_MONEY * fourMatchCount + FIVE_MATCH_MONEY * fiveMatchCount + SIX_MATCH_MONEY * sixMatchCount;
    }

}