package lotto;

import lotto.vo.LottoNumber;

import java.util.*;

public class LottoGame {
    private int manualLottoCount;
    private int automaticLottoCount;
    private List<Lotto> purchasedLotto;

    LottoGame(int money) {
        purchasedLotto = LottoStore.buyLotto(money);
        this.automaticLottoCount = purchasedLotto.size();
    }

    public LottoGame(int money, List<Lotto> manualLottos) {
        purchasedLotto = LottoStore.buyLotto(money, manualLottos);
        this.manualLottoCount = manualLottos.size();
        this.automaticLottoCount = purchasedLotto.size() - this.manualLottoCount;
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

    int getManualLottoCount() {
        return this.manualLottoCount;
    }

    int getAutomaticLottoCount() {
        return this.automaticLottoCount;
    }
}
