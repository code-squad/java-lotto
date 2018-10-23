package vo;

public enum Rank {
    NONE(0, 0), FIFTH(3, 5000), FOURTH(4, 50000), THIRD(5, 1500000), SECOND(5, 30000000), FIRST(6, 2000000000);

    private int matchNumAmt;
    private int reward;

    private Rank(int matchNumAmt, int reward) {
        this.matchNumAmt = matchNumAmt;
        this.reward = reward;
    }

    public static Rank findMatchRank(int matchNumAmt, Boolean matchBonums) {
        for (Rank rank : Rank.values()) {
            if (matchNumAmt == SECOND.getMatchNumAmt())
                return matchBonums ? SECOND : THIRD;
            if (matchNumAmt == rank.getMatchNumAmt()) return rank;
        }
        return Rank.NONE;
    }

    public int getMatchNumAmt() {
        return this.matchNumAmt;
    }

    public int getReward() {
        return this.reward;
    }

}


