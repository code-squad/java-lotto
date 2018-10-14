package com.zingoworks.lotto.controller;

import com.zingoworks.lotto.domain.FullGame;
import com.zingoworks.lotto.domain.LottoResults;
import com.zingoworks.lotto.view.InputView;
import com.zingoworks.lotto.view.ResultView;

public class LottoMain {
    public static final int PRICE_OF_GAME = 1000;

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        FullGame fullGame = new FullGame(purchaseAmount);

        ResultView.printGames(purchaseAmount, fullGame);

        String lastWinningNumbers = InputView.inputLastWinningNumbers();

        LottoResults lottoResults = new LottoResults(fullGame, lastWinningNumbers);

        ResultView.printResults(lottoResults, purchaseAmount);
    }
}
