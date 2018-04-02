package lotto.domain;

public enum Match {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchCount;
    private int prize;

    private Match(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
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
}
