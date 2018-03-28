package domain;

import domain.result.LottoResult;
import domain.result.LottoResults;
import domain.result.Rank;
import utils.LottoMachine;

import java.util.List;

public class LottoBundle {
    private List<Lotto> lottoBundle;

    public LottoBundle(int amount) {
        if (LottoMachine.isImPossibleBuy(amount)) {
            throw new IllegalArgumentException("돈이 부족하여 구매할 수 없습니다.");
        }
        lottoBundle = buyLotto(amount);
    }

    private static List<Lotto> buyLotto(int amount) {
        LottoMachine machine = LottoMachine.of();
        return machine.publishLotto(amount);
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
        if (Rank.isNotRank(matchPoint)) {
            return;
        }

        if (Rank.isBonusSituation(matchPoint)) {
            boolean isBonusMatch = winningLotto.matchBonus(lotto);
            results.addResult(new LottoResult(Rank.of(isBonusMatch)));
        }
        results.addResult(new LottoResult(Rank.of(matchPoint)));
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
