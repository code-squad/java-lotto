import domain.*;
import view.InputView;
import view.ResultView;

import java.io.IOException;

public class LottoGame {
    public static void main(String[] args) {
        try {
            goLotto();
        } catch (IllegalArgumentException|IOException e){
            System.out.println("invalid input");
            e.printStackTrace();
        }
    }

    private static void goLotto() throws IOException {
        LottoBundle theLottoBundle = LottoFactory.generateRandomLottoBundle(InputView.inputCount());
        ResultView.showLottoBundles(theLottoBundle.toDto());

        WinningLotto theWinningLotto =
                LottoFactory.generateWinningLotto(InputView.inputWinningLottoNumbers(), InputView.inputBonusBall());
        WinStats theWinStats = theLottoBundle.calculateWinStats(theWinningLotto);
        ResultView.showResultMessage(theWinStats.toDto());
    }
}
