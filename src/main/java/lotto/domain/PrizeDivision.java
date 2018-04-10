package lotto.domain;

import java.util.Arrays;

public enum PrizeDivision {
    FIRST(6, 2_000_000_000, "1등"), 
    SECOND(5, 1_500_000, "2등"),
    THIRD(4, 50_000, "3등"),
    FOURTH(3, 5_000, "4등"), 
    DEFAULT(0, 0, "미당첨");

    private int matchedNumber;
    private int prize;
    private String description;

    PrizeDivision(int matchedNumber, int prize, String description) {
        this.matchedNumber = matchedNumber;
        this.prize = prize;
        this.description = description;
    }

    public static PrizeDivision findByMatchedNumbers(int expected) {
        return Arrays.stream(PrizeDivision.values())
                .filter(division -> division.matchNumberEqualsOf(expected))
                .findFirst()
                .orElse(DEFAULT);
    }

    public boolean matchNumberEqualsOf(int expected) {
        return matchedNumber == expected;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getPrize() {
        return prize;
    }
}
