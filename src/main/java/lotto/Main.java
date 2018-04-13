package lotto;

import lotto.domain.*;
import lotto.view.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int purchasePrice = InputView.initPurchasePrice();
        LottoGame lottoGame = new LottoGame(purchasePrice);
        OutputView.printPurchasedLotto(lottoGame);

        List<Integer> lastPrizeOfNumbers = InputView.initLastPrizeOfNumber();
        LottoGameResult lottoGameResult = lottoGame.play(lastPrizeOfNumbers);
        OutputView.printLottoResult(lottoGameResult);
    }
}
