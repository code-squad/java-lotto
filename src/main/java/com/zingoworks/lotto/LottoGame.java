package com.zingoworks.lotto;

import com.zingoworks.lotto.model.LottoResult;
import com.zingoworks.lotto.model.Money;
import com.zingoworks.lotto.model.lotto.*;
import com.zingoworks.lotto.model.lotto.lottoPack.LottoPack;
import com.zingoworks.lotto.view.InputView;
import com.zingoworks.lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int amountOfManualLotto = InputView.inputManualLottoAmounts();
        List<String> givenManualLottoNumbers = InputView.inputManualLottoNumbers(amountOfManualLotto);

        Money money = new Money(purchaseAmount);
        LottoPack lottoPack = new LottoPack(money, givenManualLottoNumbers);

        ResultView.printLottoNumbers(lottoPack);

        String givenLastWinningNumbers = InputView.inputLastWinningNumbers();
        int givenBonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(Lotto.of(givenLastWinningNumbers), givenBonusNumber);
        LottoResult lottoResult = new LottoResult(lottoPack, winningLotto);

        ResultView.printResults(lottoResult, money);
    }
}
