package lotto;

import lotto.domain.LottoManager;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoManager lottos;
        try {
            Money money = InputView.buyLotto();
            int createCount = InputView.buyManualLottoCount(money); // 수동 로또 생성 개수
            lottos = LottoManager.buyLotto(money, InputView.manualLotto(createCount));
            ResultView.printLotto(lottos);
            WinningLotto winningLotto = new WinningLotto(InputView.lastWeekWinNumber(), InputView.bonusBall());
            lottos.winLottoMatch(winningLotto);
            ResultView.winList(lottos, money.yield(lottos));
        } catch (InputMismatchException | IllegalArgumentException e) { // 타입 에러
            System.out.println(e.getMessage());
            main(args);
        }
    }
}
