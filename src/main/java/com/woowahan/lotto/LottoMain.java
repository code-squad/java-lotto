package com.woowahan.lotto;

import java.util.List;
import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoController lottoController = new LottoController();
        ResultView resultView = new ResultView();

        int money = inputView.inputMoney();
        List<Lotto> lottos = lottoController.buy(money);

        resultView.printMyLottoInfo(lottos);
        List<Integer> luckyNumbers = inputView.inputLuckyNumbers();

        Map<PriceInfo, Integer> winInfo = lottoController.checkAllLottos(lottos, luckyNumbers);
        resultView.printLottoResult(winInfo);

    }

}
