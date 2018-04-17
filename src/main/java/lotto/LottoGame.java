package lotto;

import lotto.vo.LottoNumber;

import java.util.*;

public class LottoGame {
    private List<Lotto> purchasedLotto;

    public LottoGame(int money) {
        purchasedLotto = LottoStore.buyLotto(money);
    }

    public GameResult play(List<Integer> numbers, int number) {
        WinningLotto winningLotto = new WinningLotto(Lotto.of(numbers), LottoNumber.of(number));
        return play(winningLotto);
    }

    private GameResult play(WinningLotto winningLotto) {
        GameResult result = new GameResult();
        for (Lotto lotto : purchasedLotto) {
            result.accumulateWinLotto(winningLotto.rank(lotto));
        }
        return result;
    }

    List<Lotto> getPurchasedLotto() {
        return this.purchasedLotto;
    }
}
