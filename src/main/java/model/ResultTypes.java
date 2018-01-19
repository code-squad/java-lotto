package model;

import java.util.Arrays;

public enum ResultTypes {

    NO_MATCH(0, 0),
    MATCH3((int) Math.pow(2, 3), 5000),
    MATCH4((int) Math.pow(2, 4), 50000),
    MATCH5((int) Math.pow(2, 5), 1500000),
    MATCH5_BONUS((int) Math.pow(2, 5) * 3, 30000000),
    MATCH6((int) Math.pow(2, 6), 2000000000);

    private int code;
    private int prize;

    ResultTypes(int matchCount, int prize) {
        this.code = matchCount;
        this.prize = prize;
    }

    public static ResultTypes findByCode(int matchCount) {
        return findByCode(matchCount, false);
    }

    public static ResultTypes findByCode(int matchCount, boolean isBonus) {
        int bonus = isBonus ? 1 : 0;
        return Arrays.stream(ResultTypes.values())
                .filter(result -> result.hasCode((int)(Math.pow(2, matchCount) * Math.pow(3, bonus))))
                .findAny()
                .orElse(NO_MATCH);
    }

    public long calculatePrize(int count) {
        return this.prize * count;
    }

    public boolean hasCode(int code) {
        return this.code == code;
    }

    public int getMatchCount() {
        int matchCount = 0;
        int temp = this.code;

        while(temp % 2 == 0) {
            matchCount++;
            temp /= 2;
        }

        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonus() {
        return code % 3 == 0;
    }
}
