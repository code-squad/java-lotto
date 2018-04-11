package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    BLANK(0, 0);

    private final int matchCount;
    private final long prizeMoney;

    Rank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public long totalPrizeMoney(int count) {
        return prizeMoney * count;
    }

    public static Rank getRank(int matchCount) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return BLANK;
    }

    public String print(int count) {
        return matchCount + "개 일치 (" + prizeMoney + "원)- " + count + "개";
    }
}
