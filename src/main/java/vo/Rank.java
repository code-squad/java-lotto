package vo;

public enum Rank {
    FIRST(6, Money.of(2000000000)),
    SECOND(5, Money.of(30000000)),
    THIRD(5, Money.of(1500000)),
    FOURTH(4, Money.of(50000)),
    FIFTH(3, Money.of(5000));

    private int matchCount;
    private Money reward;

    Rank(int matchCount, Money reward) {
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

    public Money calculateTotalReward(int count) {
        return this.reward.multi(count);
    }
}
