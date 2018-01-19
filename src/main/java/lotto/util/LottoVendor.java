package lotto.util;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.io.InputView;
import lotto.io.OutputView;

import java.util.List;

public class LottoVendor {

    private final static int LOTTO_PRICE = 1000;
    private static LottoVendor instance;

    private LottoVendor() {
    }

    public static LottoVendor getInstance() {
        if ( instance == null ) {
            instance = new LottoVendor();
        }
        return instance;
    }

    public int moneyToLottoCount(String money) {
        if (!LottoUtil.isNumeric(money)) throw new IllegalArgumentException();
        return unitPerLotto(Integer.parseInt(money));
    }

    public int unitPerLotto(Integer money) {
        if (money < LOTTO_PRICE) throw new IllegalArgumentException();
        return money/LOTTO_PRICE;
    }

    public Lotteries buy(int count, boolean manual) {
        return order(count, manual);
    }

    private Lotteries order(Integer count, boolean manual) {
        if (manual) return InputView.inputManualLotteries(count);
        return createAutoLotteries(count);
    }

    private Lotteries createAutoLotteries(Integer count) {
        Lotteries lottery = new Lotteries();
        for (Integer i = 0; i < count; i++) {
            lottery.add(new Lotto());
        }
        return lottery;
    }

    public Lotteries buy(String money) {
        return new Lotteries(makeLotto(moneyToLottoCount(money)));
    }

    private Lotteries makeLotto(int lottoCount) {
        Lotteries manualLotto = buy(InputView.orderCountByUser(lottoCount), true);
        lottoCount -= manualLotto.size();

        Lotteries autoLotto = buy(lottoCount, false);
        OutputView.printLotto(manualLotto, autoLotto);
        return manualLotto.concat(autoLotto);
    }

    public void result(Lotteries lotteries) {
        Lotto jackpot = InputView.inputManualLotto("지난 주 당첨 번호를 입력해 주세요.");
        LottoNumber luckyNumber = InputView.inputLuckyNumber(jackpot);

        OutputView.printResult(jackpot.match(lotteries, luckyNumber));
    }
}