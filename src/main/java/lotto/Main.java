package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.util.LottoVendor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Lotto> myLotto = LottoVendor.getInstance().buy(InputView.inputMoney());
        OutputView.printLotto(myLotto);
        Lotto jackpot = InputView.inputLastLottoNumber();
        LottoNumber luckyNumber = InputView.inputLuckyNumber(jackpot);
        OutputView.printResult(jackpot.match(myLotto, luckyNumber));

    }
}
