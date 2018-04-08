package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoProvider;
import lotto.domain.LottoStatistics;

/**
 * @author sangsik.kim
 */
public class Console {
    public static void main(String[] args) {
        LottoGame lottoGame = LottoProvider.order(InputView.getAmount());

        ResultView.printLottos(lottoGame.getLottos());

        ResultView.printStatistics(new LottoStatistics(lottoGame, InputView.getWinningNumbers()));
    }
}
