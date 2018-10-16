package com.zingoworks.lotto.controller;

import com.zingoworks.lotto.domain.Lotteries;
import com.zingoworks.lotto.domain.Lottery;
import com.zingoworks.lotto.domain.LottoResult;
import com.zingoworks.lotto.view.InputView;
import com.zingoworks.lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();

            List<Lottery> lotteries = Lotteries.getAllLotteries(purchaseAmount);
            ResultView.printGames(lotteries, purchaseAmount);

            String lastWinningNumbers = InputView.inputLastWinningNumbers();
            LottoResult lottoResult = new LottoResult(lotteries, lastWinningNumbers);
            ResultView.printResults(lottoResult, purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            main(args);
        }
    }
}
