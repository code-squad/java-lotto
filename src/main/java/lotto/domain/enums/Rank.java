package lotto.domain.enums;

import java.util.Arrays;

public enum Rank {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_DOUBLE(5, 30000000),
    SIX(6, 2000000000);

    private int value;
    private int profit;

    Rank(int value, int profit) {
        this.value = value;
        this.profit = profit;
    }

    public boolean isEqualCount(int count) {
        return value == count;
    }

    public int getValue() {
        return value;
    }

    public int getProfit() {
        return profit;
    }

    public static Rank match(int count, boolean matchBall) {
        if(FOUR.isEqualCount(count) && matchBall) return FIVE_DOUBLE;

        return Arrays.stream(Rank.values())
                .filter(lottoCorrectCount -> lottoCorrectCount.isEqualCount(count))
                .findFirst().get();
    }
}
