package com.zingoworks.lotto.controller;

import com.zingoworks.lotto.domain.Lotteries;
import com.zingoworks.lotto.domain.Lottery;
import com.zingoworks.lotto.domain.LottoResult;
import com.zingoworks.lotto.domain.WinningLottery;
import com.zingoworks.lotto.view.InputView;
import com.zingoworks.lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            List<Lottery> lotteries = Lotteries.getAllLotteries(purchaseAmount);

            ResultView.printLottoNumbers(lotteries, purchaseAmount);

            String lastWinningNumbers = InputView.inputLastWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();
            WinningLottery winningLottery = new WinningLottery(lastWinningNumbers, bonusNumber);
            LottoResult lottoResult = new LottoResult(lotteries, winningLottery);

            ResultView.printResults(lottoResult, purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            main(args);
        }
    }
}
