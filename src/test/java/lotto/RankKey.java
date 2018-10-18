package lotto;

import java.util.Objects;

public class RankKey {
    private Integer lottoMatchRank;
    private boolean bonusBallMatchRank;

    public RankKey(Integer lottoMatchRank, boolean bonusBallMatchRank) {
        this.lottoMatchRank = lottoMatchRank;
        this.bonusBallMatchRank = bonusBallMatchRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankKey rankKey = (RankKey) o;
        return Objects.equals(lottoMatchRank, rankKey.lottoMatchRank) &&
                Objects.equals(bonusBallMatchRank, rankKey.bonusBallMatchRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoMatchRank, bonusBallMatchRank);
    }
}
