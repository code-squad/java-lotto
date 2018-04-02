package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchCount;
    private int prize;

    private Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank ofRank(int matchCount, boolean bonus) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (matchCount == SECOND.matchCount) {
                return bonus ? SECOND : THIRD;
            }
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return null;
    }
}
