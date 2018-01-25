package enums;

public enum WinningRules {
    NONE(0, 0, false),
    ONE_MATCHING(1, 0, false),
    TWO_MATCHING(2, 0, false),
    THREE_MATCHING(3, 5000, false),
    FOUR_MATCHING(4, 50000, false),
    FIVE_MATCHING(5, 150000, false),
    BONUS_MATCHING(5, 30000000, true),
    SIX_MATCHING(6, 200000000, false);

    private Integer matchCount;
    private Integer reward;
    private boolean isBonusMatching;

    WinningRules(Integer matchCount, Integer reward, boolean isBonusMatching) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.isBonusMatching = isBonusMatching;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getReward() {
        return reward;
    }
}
