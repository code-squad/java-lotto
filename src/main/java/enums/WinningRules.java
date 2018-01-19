package enums;

public enum WinningRules {
    NONE(0, 0),
    ONE_MATCHING(1, 0),
    TWO_MATCHING(2, 0),
    THREE_MATCHING(3, 5000),
    FOUR_MATCHING(4, 50000),
    FIVE_MATCHING(5, 150000),
    SIX_MATCHING(6, 200000000);

    private Integer matchCount;
    private Integer reward;

    WinningRules(Integer matchCount, Integer reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getReward() {
        return reward;
    }
}
