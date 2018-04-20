package com.codesquad.lotto.app;

import com.codesquad.lotto.application.LottoGame;
import com.codesquad.lotto.application.LottoGameResult;
import com.codesquad.lotto.infrastructure.DefaultShuffler;
import com.codesquad.lotto.view.InputView;
import com.codesquad.lotto.view.ResultView;

import java.util.List;

public class ConsoleLottoApp {
    public static void main(final String[] args) {
        final int amount = InputView.inputPayment();
        final LottoGame lottoGame = new LottoGame(amount, new DefaultShuffler());
        ResultView.printLotto(lottoGame);

        System.out.println();

        final List<String> winningNumbers = InputView.inputWinningNumbers();
        final LottoGameResult gameResult = lottoGame.play(winningNumbers);
        ResultView.statistic(gameResult);
    }
}
