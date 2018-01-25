package domain;

public class LottoResult {
    private Rank rank;
    private int count;

    public LottoResult(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    @Override
    public String toString() {
        return rank.toString() + count + "개";
    }
}
