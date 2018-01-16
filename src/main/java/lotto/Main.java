package lotto;

import lotto.domain.Lotto;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.util.LottoRecorder;
import lotto.util.LottoVendor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Lotto> myLotto = LottoVendor.getInstance().buy(InputView.inputMoney());
        OutputView.printLotto(myLotto);
        Lotto jackpot = new Lotto(InputView.inputLastLottoNumber());
        LottoRecorder lottoRecorder = jackpot.match(myLotto);
        OutputView.printResult(lottoRecorder);

    }
}
