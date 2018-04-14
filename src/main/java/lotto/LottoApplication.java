package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int amount = InputView.getAmount();
        int manualLottoCount = InputView.getManualLottoCount();
        List<List<String>> manualLotto = InputView.getManualLotto(manualLottoCount);

        LottoGame lottoGame = new LottoGame(amount, manualLotto);
        ResultView.printLotto(lottoGame);

        List<String> winningNumber = InputView.getWinningNumber();
        String bonusNumber = InputView.getBonusNumber();

        GameResult gameResult = lottoGame.play(winningNumber, bonusNumber);
        ResultView.statistic(gameResult, amount);
    }
}
