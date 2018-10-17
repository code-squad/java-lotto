package lottogame.domain;

public enum PrizeRank {
    NO_MISS(6, 2000000000, "6개 일치 (2000000000원)"),
    ONE_MISS_BONUS_HIT(5, 30000000, "5개 일치, 보너스 볼 일치(30000000원)"),
    ONE_MISS(5, 1500000, "5개 일치 (1500000원)"),
    TWO_MISS(4, 50000, "4개 일치 (50000원)"),
    THREE_MISS(3, 5000, "3개 일치 (5000원)"),
    BOOM(-1, 0, "");

    private final int hitAmount;
    private final int reward;
    private final String message;

    PrizeRank(int hitAmount, int reward, String message) {
        this.hitAmount = hitAmount;
        this.reward = reward;
        this.message = message;
    }

    public static PrizeRank find(int hitAmount, boolean bonusHit) {
        if (hitAmount == 5) {
            return check(bonusHit);
        }

        for (PrizeRank value : values()) {
            if (value.getHitAmount() == hitAmount) {
                return value;
            }
        }
        return BOOM;
    }

    private static PrizeRank check(boolean bonusHit) {
        if (bonusHit) {
            return ONE_MISS_BONUS_HIT;
        }
        return ONE_MISS;
    }

    public int getHitAmount() {
        return hitAmount;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
