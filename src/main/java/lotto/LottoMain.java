package lotto;

import lotto.domain.LottoManager;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int myMoney;
        LottoManager lottos;
        try {
            myMoney = InputView.buyLotto();
            List<String> manualLottos = new ArrayList<>();
            int manualCount = InputView.buyManualLottoCount();
            for (int i = 0; i < manualCount; i++) {
                manualLottos.add(InputView.manualLotto());
            }
            lottos = LottoManager.buyLotto(myMoney, manualLottos);
            ResultView.printLotto(lottos);

            WinningLotto winningLotto = new WinningLotto(InputView.lastWeekWinNumber(), InputView.bonusBall());
            lottos.winLottoMatch(winningLotto);

            ResultView.winList(lottos);
        } catch (InputMismatchException | IllegalArgumentException e) { // 타입 에러
            System.out.println(e.getMessage());
            main(args);
        }
    }
}
