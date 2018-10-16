package com.zingoworks.lotto.controller;

import com.zingoworks.lotto.domain.FullLotto;
import com.zingoworks.lotto.domain.LottoResults;
import com.zingoworks.lotto.view.InputView;
import com.zingoworks.lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        FullLotto fullLotto = new FullLotto(purchaseAmount);

        ResultView.printGames(fullLotto, purchaseAmount);

        String lastWinningNumbers = InputView.inputLastWinningNumbers();
        LottoResults lottoResults = new LottoResults(fullLotto, lastWinningNumbers);

        ResultView.printResults(lottoResults, purchaseAmount);
    }
}
