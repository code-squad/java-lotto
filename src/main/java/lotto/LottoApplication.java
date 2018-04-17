package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        long money = InputView.inputMoney();
        LottoMachine lottoMachine = new LottoMachine(money);

        LottoProvider lotto = new LottoProvider();
        ResultView.printPurchasedLotto(lotto.purchaseLottos(money));

        Lotto winLottoNumber = InputView.inputWinNumber();
        LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonus());
        WinningLotto winLotto = new WinningLotto(winLottoNumber, bonusNumber);
        GameResult gameResult = lottoMachine.calculate(lotto.getPurchasedLottos(), winLotto);
        ResultView.printWinLotto2(gameResult);
    }
}
