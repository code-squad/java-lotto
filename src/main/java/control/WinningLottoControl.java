package control;

import domain.WinningLotto;
import utils.NumParser;
import view.InputView;

public class WinningLottoControl {

    public static WinningLotto getWinningLotto() {
        while (true) {
            try {
                String inputWinningNum = InputView.inputWinningLottoNum();
                int bonus = InputView.inputBonusNum();
                WinningLotto winningLotto = WinningLotto.ofWinningLotto(NumParser.parse(inputWinningNum), bonus);
                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
