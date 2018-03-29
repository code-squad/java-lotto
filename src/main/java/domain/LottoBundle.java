package domain;

import domain.result.LottoResult;
import domain.result.LottoResults;
import domain.result.Rank;

import java.util.List;

public class LottoBundle {
    private List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public LottoResults matchLotto(WinningLotto winningLotto) {
        LottoResults results = new LottoResults();
        for (Lotto lotto : lottoBundle) {
            addResult(results, winningLotto, lotto);
        }
        return results;
    }

    private void addResult(LottoResults results, WinningLotto winningLotto, Lotto lotto) {
        int matchPoint = winningLotto.match(lotto);
        boolean isBonusMatch = winningLotto.matchBonus(lotto);
        Rank rank = Rank.of(matchPoint, isBonusMatch);
        if (rank != null) {
            results.addResult(new LottoResult(rank));
        }
    }

    public String getPurchaseHistory() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottoBundle) {
            builder.append(lotto.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
