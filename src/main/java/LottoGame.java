import domain.*;
import view.InputView;
import view.ResultView;

import java.io.IOException;

public class LottoGame {
    public static void main(String[] args) {
        try {
            goLotto();
        } catch (IllegalArgumentException|IOException e){
            System.out.println(e.getMessage());
            main(args);
        }
    }

    private static void goLotto() throws IOException {
        Money investedMoney = new Money(InputView.inputInvestedMoney());
        LottoBundle theLottoBundle = makeLottoBundle(investedMoney.calculateCountCanBuy());
        ResultView.showLottoBundles(theLottoBundle.toDto());

        WinStats theWinStats = makeWinStats(theLottoBundle, investedMoney);
        ResultView.showResultMessage(theWinStats.toDto());
    }

    private static LottoBundle makeLottoBundle(int totalLottoCount) throws IOException {
        int manualLottoCount = InputView.inputManualLottoCount();
        if(manualLottoCount > totalLottoCount)
            throw new IllegalArgumentException("Can't enter a number greater than the total count.");

        LottoBundleFactory manualLottoBundleFactory = new ManualLottoBundleFactory(InputView.inputManualLottoTexts(manualLottoCount));
        LottoBundleFactory autoLottoBundleFactory = new AutoLottoBundleFactory();
        LottoBundle theLottoBundle = manualLottoBundleFactory.generate(manualLottoCount)
                .addAll(autoLottoBundleFactory.generate(totalLottoCount-manualLottoCount));
        ResultView.echoCount(manualLottoCount, totalLottoCount - manualLottoCount);
        return theLottoBundle;
    }

    private static WinStats makeWinStats(LottoBundle theLottoBundle, Money investedMoney) throws IOException {
        WinningLotto theWinningLotto =
                WinningLottoFactory.generateWinningLotto(InputView.inputWinningLottoNumbers(), InputView.inputBonusBall());
        return theLottoBundle.calculateWinStats(theWinningLotto, investedMoney);
    }
}
