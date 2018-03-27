package domain.result;

public class LottoResult {
    private Rank rank;

    public LottoResult(int matchPoint) {
        if (Rank.isNotRank(matchPoint)) {
            throw new IllegalArgumentException("해당하는 랭크가 없습니다.");
        }
        this.rank = Rank.of(matchPoint);
    }
}
