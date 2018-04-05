package domain.result;

public class LottoResult {
    private Rank rank;

    public LottoResult(Rank rank) {
        this.rank = rank;
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
