package lotto;

import lotto.domain.Lotto;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.util.LottoParser;
import lotto.util.LottoRecorder;
import lotto.util.LottoVendor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Lotto> myLotto = LottoVendor.getInstance().buy(InputView.inputMoney());
        OutputView.printLotto(myLotto);
        Lotto jackpot = LottoParser.parseLotto(InputView.inputLastLottoNumber());
        LottoRecorder lottoRecorder = new LottoRecorder(jackpot, myLotto);
        OutputView.printResult(lottoRecorder);

    }
}
