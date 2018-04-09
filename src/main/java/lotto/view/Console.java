package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoProvider;

/**
 * @author sangsik.kim
 */
public class Console {
    public static void main(String[] args) {
        LottoGame lottoGame = LottoProvider.order(InputView.getAmount());

        ResultView.printLottos(lottoGame.getLottos());

        ResultView.printResult(lottoGame.createResult(InputView.getWinningNumbers()));
    }
}
