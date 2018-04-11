package lotto.domain;

import java.util.Arrays;

public enum PrizeDivision {
    FIRST(6, 2_000_000_000, false, "6개 일치"),
    SECOND(5, 30_000_000, true, "5개 일치, 보너스 볼 일치"), 
    THIRD(5, 1_500_000, false, "5개 일치"),
    FOURTH(4, 50_000, false, "4개 일치"),
    FIFTH(3, 5_000, false, "3개 일치"), 
    DEFAULT(0, 0, false, "미당첨");

    private final int matchedNumber;
    private final int prize;
    private final boolean matchedBonusNumber;
    private final String description;

    PrizeDivision(int matchedNumber, int prize, boolean matchedBonusNumber, String description) {
        this.matchedNumber = matchedNumber;
        this.prize = prize;
        this.matchedBonusNumber = matchedBonusNumber;
        this.description = description;
    }

    public static PrizeDivision valueOf(int countOfMatch, boolean isMatchBonusNumber) {
        return Arrays.stream(PrizeDivision.values())
                .filter(division -> division.compareBy(countOfMatch, isMatchBonusNumber))
                .findFirst()
                .orElse(DEFAULT);
    }

    public boolean compareBy(int countOfMatch, boolean isMatchBonusNumber) {
        return getMatchedNumber() == countOfMatch 
                && isMatchedBonusNumber() == isMatchBonusNumber;
    }

    public boolean isMatchedBonusNumber() {
        return matchedBonusNumber;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
