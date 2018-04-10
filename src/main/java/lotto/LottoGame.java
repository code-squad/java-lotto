package lotto;

import java.util.*;

public class LottoGame {
    private List<Lotto> purchasedLotto;

    public LottoGame(int money) {
        purchasedLotto = LottoStore.buyLotto(money);
    }

    public GameResult play(List<Integer> winningNumber) {
        Lotto winningLotto = new Lotto(winningNumber);

        GameResult result = new GameResult();
        for (Lotto lotto : purchasedLotto) {
            accumulateWinLottoCount(winningLotto, result, lotto);
        }
        return result;
    }

    private void accumulateWinLottoCount(Lotto winningLotto, GameResult result, Lotto lotto) {
        result.accumulateWinLottoCount(lotto.matcherNumber(winningLotto));
    }

    List<Lotto> getPurchasedLotto() {
        return this.purchasedLotto;
    }
}
