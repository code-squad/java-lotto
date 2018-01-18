package com.woowahan.lotto;

import java.util.List;
import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoController lottoController = new LottoController();
        ResultView resultView = new ResultView();

        int money = inputView.inputMoney();
        List<UserLotto> lottos = lottoController.buy(money);

        resultView.printMyLottoInfo(lottos);
        WinningLotto winningLotto = new WinningLotto(inputView.inputLuckyNumbers(), inputView.inputBonusNumber());

        Map<PriceInfo, Integer> winInfo = lottoController.checkAllLottos(lottos, winningLotto);
        resultView.printLottoResult(winInfo);

    }

}
