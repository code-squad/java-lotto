package com.woowahan.lotto;

import com.woowahan.lotto.controller.LottoController;
import com.woowahan.lotto.model.Lotto;
import com.woowahan.lotto.model.LottoResult;
import com.woowahan.lotto.model.WinningLotto;
import com.woowahan.lotto.view.InputView;
import com.woowahan.lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoController lottoController = new LottoController();
        ResultView resultView = new ResultView();

        int money = inputView.inputMoney();
        List<Lotto> lottos = lottoController.buy(money);

        resultView.printMyLottoInfo(lottos);
        WinningLotto winningLotto = new WinningLotto(inputView.inputLuckyNumbers(), inputView.inputBonusNumber());

        LottoResult lottoResult = lottoController.checkAllLottos(lottos, winningLotto);
        int benefit = lottoResult.calculateBenefit(money);

        resultView.printLottoResult(lottoResult, benefit);

    }

}
