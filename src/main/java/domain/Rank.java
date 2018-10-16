package domain;

import java.util.Random;

public enum Rank {
    NONE(0, 0), FOURTH(3, 5000), THIRD(4, 50000), SECOND(5, 1500000), FIRST(6, 2000000000);

    private int matchNumAmt;
    private int reward;

    private Rank(int matchNumAmt, int reward) {
        this.matchNumAmt = matchNumAmt;
        this.reward = reward;
    }

    public int getMatchNumAmt() {
        return this.matchNumAmt;
    }

    public static Rank findMatchRank(int matchNumAmt) {
        for (Rank rank : Rank.values()) {
            if (matchNumAmt == rank.getMatchNumAmt()) return rank;
        }
        return Rank.NONE;
    }

    public int getReward() {
        return this.reward;
    }

}
