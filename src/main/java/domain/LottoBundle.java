package domain;

import domain.result.LottoResult;
import domain.result.LottoResults;
import domain.result.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private List<Lotto> lottos = new ArrayList<>();

    public void addLotto(List<Lotto> lottoBundle) {
        if (lottoBundle == null) {
            return;
        }
        lottos.addAll(lottoBundle);
    }

    public LottoResults matchLotto(WinningLotto winningLotto) {
        LottoResults results = new LottoResults();
        for (Lotto lotto : lottos) {
            addResult(results, winningLotto, lotto);
        }
        results.calcProfit(lottos.size());
        results.setResultMessage();
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
        for (Lotto lotto : lottos) {
            builder.append(lotto.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public boolean isExistPurchaseHistory() {
        return !lottos.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottos) {
            builder.append(lotto);
            builder.append("\n");
        }
        return builder.toString();
    }


    public List<String> getSavableLottoNumbers() {
        ArrayList<String> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.getSavableLottoNumber());
        }
        return lottoNumbers;
    }
}
