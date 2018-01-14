package enums;

public enum LottoPrize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int numOfMatch;
    private int cashPrize;

    LottoPrize(int rank, int prize) {
        this.numOfMatch = rank;
        this.cashPrize = prize;
    }

    public boolean isMatch(int numOfMatch) {
        return this.numOfMatch == numOfMatch;
    }

    public static LottoPrize valueOf(int numOfMatch, boolean matchBonus) {
        if(numOfMatch == 5)
            return matchBonus ? SECOND : THIRD;

        for(LottoPrize prize : values())
            if(prize.isMatch(numOfMatch))
                return prize;

        return null;
    }
}
