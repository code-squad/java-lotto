package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoProvider;
import lotto.domain.LottoResult;

/**
 * @author sangsik.kim
 */
public class Console {
    public static void main(String[] args) {
        LottoGame lottoGame = LottoProvider.order(InputView.getAmount());
        ResultView.printLottos(lottoGame.getLottos());

        Lotto winningLotto = InputView.getWinningLotto();
        Integer bonusNumber = InputView.getBonusNumber();

        LottoResult result = lottoGame.createResult(winningLotto, bonusNumber);
        ResultView.printResult(result);
    }
}
