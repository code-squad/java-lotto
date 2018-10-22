package domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int matchCount;
    private int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus){
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if(matchCount == SECOND.matchCount) return matchBonus ? SECOND : THIRD;
            if(rank.matchCount == matchCount) return rank;
        }
        return null;
    }
}
