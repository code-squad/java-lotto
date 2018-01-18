package model;

import java.util.Arrays;

public enum ResultTypes {

    NO_MATCH(0, 0),
    MATCH3(3, 5000),
    MATCH4(4, 50000),
    MATCH5(5, 1500000),
    MATCH5_BONUS(5, 30000000, true),
    MATCH6(6, 2000000000);

    ResultTypes(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    ResultTypes(int matchCount, int prize, boolean bonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
    }

    public static ResultTypes findByCode(int code, boolean isBonus) {
        return Arrays.stream(ResultTypes.values())
                .filter(result -> result.hasCode(code, isBonus))
                .findAny()
                .orElse(NO_MATCH);
    }

    public boolean hasCode(int code, boolean isBonus) {
        return this.matchCount == code && this.bonus == isBonus;
    }

    public int matchCount;
    public boolean bonus;
    public int prize;

}
