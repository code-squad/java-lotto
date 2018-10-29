package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.InputMismatchException;

public class LottoMain {
    public static void main(String[] args) {
        int myMoney;
        LottoManager lottos;
        try {
            myMoney = InputView.buyLotto();
            lottos = LottoManager.buyLotto(myMoney);
            ResultView.printLotto(lottos);

            Lotto winLotto = Lotto.ofWinLotto(InputView.lastWeekWinNumber());
            lottos.winLottoMatch(winLotto, InputView.bonusBall());

            ResultView.winList(lottos);
        } catch (InputMismatchException | IllegalArgumentException e) { // 타입 에러
            System.out.println(e.getMessage());
            main(args);
        }
    }
}
