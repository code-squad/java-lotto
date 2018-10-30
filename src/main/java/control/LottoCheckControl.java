package control;

import domain.GameResult;
import domain.LottoGame;
import view.InputView;

public class LottoCheckControl {

    public static GameResult getLottoResult(LottoGame lottoGame) {
        while (true) {
            try {
                return lottoGame.checkLottos(InputView.inputWinningLottoNum(), InputView.inputBonusNum());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
