package enums;

public enum LottoPrize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int numOfMatch;
    private int cashPrize;

    LottoPrize(int rank, int prize) {
        this.numOfMatch = rank;
        this.cashPrize = prize;
    }

    public boolean isMatch(int numOfMatch) {
        return this.numOfMatch == numOfMatch;
    }

    public int getTotalPrize(int numOfLotto) {
        return this.cashPrize * numOfLotto;
    }

    public String getState(int numOfMatchLotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.numOfMatch).append("개 일치")
                .append(this.equals(LottoPrize.SECOND) ? ", 보너스 볼 일치 (" : " (")
                .append(this.cashPrize).append("원)- ")
                .append(numOfMatchLotto).append("개\n");

        return sb.toString();
    }

    public static LottoPrize valueOf(int numOfMatch, boolean matchBonus) {
        if(isMatchNumIsFIVE(numOfMatch))
            return matchBonus ? SECOND : THIRD;

        for(LottoPrize prize : values())
            if(prize.isMatch(numOfMatch))
                return prize;

        return null;
    }

    private static boolean isMatchNumIsFIVE(int num) {
        return num == 5;
    }
}
