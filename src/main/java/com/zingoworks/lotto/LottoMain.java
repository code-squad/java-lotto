package com.zingoworks.lotto;

import com.zingoworks.lotto.domain.LottoResult;
import com.zingoworks.lotto.domain.Lottos;
import com.zingoworks.lotto.domain.WinningLotto;
import com.zingoworks.lotto.view.InputView;
import com.zingoworks.lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            int manualLottoAmounts = InputView.inputManualLottoAmounts();
            List<String> manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoAmounts);

            Lottos lottos = new Lottos(purchaseAmount, manualLottoNumbers);
            ResultView.printLottoNumbers(lottos);

            String lastWinningNumbers = InputView.inputLastWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();
            WinningLotto winningLotto = new WinningLotto(lastWinningNumbers, bonusNumber);
            LottoResult lottoResult = lottos.match(winningLotto);

            ResultView.printResults(lottoResult, purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            main(args);
        }
    }
}