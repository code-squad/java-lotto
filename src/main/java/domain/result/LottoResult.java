package domain.result;

public class LottoResult {
    private Rank rank;

    public LottoResult(Rank rank) {
        this.rank = rank;
    }

    public int getPrizeMoney() {
        return rank.getPrize();
    }

    public boolean isSameRank(Rank rank) {
        return this.rank == rank;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "rank=" + rank.toString() +
                '}';
    }
}
