package lottogame.domain;

public enum PrizeRank {
    FIRST_PLACE(6,2000000000),
    SECOND_PLACE(5,1500000),
    THIRD_PLACE(4,50000),
    FOURTH_PLACE(3,5000),
    BOOM(-1, 0);

    private final int hitAmount;
    private final int rewardMoney;

    PrizeRank(int hitAmount, int rewardMoney) {
        this.hitAmount = hitAmount;
        this.rewardMoney = rewardMoney;
    }

    public int getHitAmount() {
        return hitAmount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static PrizeRank find(int hitAmount) {
        for (PrizeRank value : values()) {
            if (value.getHitAmount() == hitAmount) {
                return value;
            }
        }
        return BOOM;
    }
}
