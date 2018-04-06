package lotto.domain;

public enum Match {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private int prize;

    private Match(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Match ofMatch(int matchCount, boolean bonus) {
        Match[] matches = values();
        for (Match match : matches) {
            if (matchCount == SECOND.matchCount) {
                return bonus ? SECOND : THIRD;
            }
            if (match.matchCount == matchCount) {
                return match;
            }
        }
        return null;
    }

    public int calculatePrize(int count) {
        return count * prize;
    }

    public boolean isSecond() {
        return SECOND == this;
    }

    @Override
    public String toString() {
        if (this != SECOND) {
            return matchCount + "개 일치 (" + prize + "원)- ";
        }
        return matchCount + "개 일치, 보너스 볼 일치 (" + prize + "원)- ";
    }
}