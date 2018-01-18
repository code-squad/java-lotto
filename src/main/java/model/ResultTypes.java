package model;

import java.util.Arrays;

public enum ResultTypes {

    NO_MATCH(0, 0),
    MATCH3((int) Math.pow(2, 3), 5000),
    MATCH4((int) Math.pow(2, 4), 50000),
    MATCH5((int) Math.pow(2, 5), 1500000),
    MATCH5_BONUS((int) Math.pow(2, 5) * 3, 30000000, true),
    MATCH6((int) Math.pow(2, 6), 2000000000);

    public int matchCount;
    public boolean bonus;
    public int prize;

    ResultTypes(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    ResultTypes(int matchCount, int prize, boolean bonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
    }

    public static ResultTypes findByCode(int code, boolean isBonus) {
        int bonus = isBonus ? 1 : 0;
        return Arrays.stream(ResultTypes.values())
                .filter(result -> result.hasCode((int)(Math.pow(2, code) * Math.pow(3, bonus))))
                .findAny()
                .orElse(NO_MATCH);
    }

    public long calculatePrize(int count) {
        return this.prize * count;
    }

    public boolean hasCode(int code) {
        return this.matchCount == code;
    }

}
