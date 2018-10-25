package com.zingoworks.lotto;

import com.zingoworks.lotto.domain.Lottos;
import com.zingoworks.lotto.domain.LottoResult;
import com.zingoworks.lotto.domain.WinningLotto;
import com.zingoworks.lotto.view.InputView;
import com.zingoworks.lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            Lottos lottos = new Lottos(purchaseAmount);

            ResultView.printLottoNumbers(lottos, purchaseAmount);

            String lastWinningNumbers = InputView.inputLastWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();
            WinningLotto winningLotto = new WinningLotto(lastWinningNumbers, bonusNumber);
            LottoResult lottoResult = lottos.match(winningLotto);
            //위 행과 LottoResult lottoResult = new LottoResult(lottos, winningLotto);는 어떤 유의미한 차이 존재하는가?

            ResultView.printResults(lottoResult, purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            main(args);
        }
    }
}