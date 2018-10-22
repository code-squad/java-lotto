package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        int price = InputView.buyLotto();
        LottoGame lottoGame = new LottoGame(price);

        ResultView.printBuyLotto(lottoGame.getLottos());
        Map map = lottoGame.compare(InputView.getWinningNumber());
        ResultView.statisticsLottoWinnings(map, price);
    }
}
