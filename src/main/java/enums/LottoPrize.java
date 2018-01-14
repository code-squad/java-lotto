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

    public int getNumOfMatch() {
        return numOfMatch;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public boolean isMatch(int numOfMatch) {
        return this.numOfMatch == numOfMatch;
    }

    public int getTotalPrize(int numOfLotto) {
        return this.cashPrize * numOfLotto;
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
