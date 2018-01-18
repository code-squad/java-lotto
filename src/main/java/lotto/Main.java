package lotto;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.util.LottoVendor;

public class Main {
    public static void main(String[] args) {
        Lotteries myLotto = LottoVendor.getInstance().buy(InputView.inputMoney());
        OutputView.printLotto(myLotto);
        Lotto jackpot = InputView.inputLastLottoNumber();
        LottoNumber luckyNumber = InputView.inputLuckyNumber(jackpot);
        OutputView.printResult(jackpot.match(myLotto, luckyNumber));

    }
}
