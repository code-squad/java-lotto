package com.zingoworks.lotto.controller;

import com.zingoworks.lotto.domain.Lotto;
import com.zingoworks.lotto.domain.Lottos;
import com.zingoworks.lotto.domain.LottoResult;
import com.zingoworks.lotto.domain.WinningLotto;
import com.zingoworks.lotto.view.InputView;
import com.zingoworks.lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            List<Lotto> lotteries = Lottos.getAllLottos(purchaseAmount);

            ResultView.printLottoNumbers(lotteries, purchaseAmount);

            String lastWinningNumbers = InputView.inputLastWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();
            WinningLotto winningLotto = new WinningLotto(lastWinningNumbers, bonusNumber);
            LottoResult lottoResult = new LottoResult(lotteries, winningLotto);

            ResultView.printResults(lottoResult, purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            main(args);
        }
    }
}