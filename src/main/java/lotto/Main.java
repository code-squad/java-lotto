package lotto;

import lotto.domain.*;
import lotto.view.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int purchasePrice = InputView.initPurchasePrice();
        int manualPurchaseCount = InputView.initManualPurchaseCount();
        List<String> manualPurchaseOfNumber = InputView.initManualPurchaseOfNumber(manualPurchaseCount);

        LottoGame lottoGame = new LottoGame(purchasePrice, manualPurchaseOfNumber);
        OutputView.printPurchasedLotto(lottoGame);

        List<Integer> lastPrizeOfNumbers = InputView.initLastPrizeOfNumber();
        int bonusNumber = InputView.initBonusNumber();
        LottoGameResult lottoGameResult = lottoGame.play(lastPrizeOfNumbers, bonusNumber);
        OutputView.printLottoResult(lottoGameResult);
    }
}
