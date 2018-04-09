package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000);

    private int matchCount;
    private long prizeMoney;

    Rank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int matchCount() {
        return matchCount;
    }

    public long prizeMoney() {
        return prizeMoney;
    }
}
