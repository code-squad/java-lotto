package lotto;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    MISS(0, 0, false);

    private final int matchCount;
    private final int money;
    private final boolean matchBonusNumber;

    Prize(int matchCount, int money, boolean matchBonusNumber) {
        this.matchCount = matchCount;
        this.money = money;
        this.matchBonusNumber = matchBonusNumber;
    }

    public int getMoney() {
        return this.money;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean isMatchBonusNumber() {
        return this.matchBonusNumber;
    }

    public static Prize findPrize(int matchCount, boolean matchBonusNumber) {
        return Arrays.stream(Prize.values()).filter(c-> c.compareBy(matchCount, matchBonusNumber)).findFirst().orElse(MISS);
    }

    private boolean compareBy(int matchCount, boolean matchBonusNumber) {
        if (SECOND.matchCount != matchCount) {
            return getMatchCount() == matchCount;
        }
        return getMatchCount() == matchCount && isMatchBonusNumber() == matchBonusNumber;
    }
}