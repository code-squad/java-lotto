package domain;

import dto.LottoResult;
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

    public LottoResult matchLotto(LottoWiningNum winningNumber) {
        LottoResult results = new LottoResult();
        for (Lotto lotto : lottoBundle) {
            results.addResult(lotto.match(winningNumber));
        }
        return results;
    }
}
