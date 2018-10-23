package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int price = InputView.buyLotto();
        LottoGame lottoGame = new LottoGame(price);
        ResultView.printBuyLotto(lottoGame.getLottos());
        lottoGame.compare(InputView.getWinningNumber(), InputView.getWinningBonusNumber());
        ResultView.statisticsLottoWinnings(price);
    }
}
