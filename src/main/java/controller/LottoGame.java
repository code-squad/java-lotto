package controller;

import domain.LottoFactory;
import domain.WinnerLotto;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static int inputMoney() {
        int count;
        try {
            count = InputView.lottoSize(InputView.input());
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
        return count;
    }

    public static WinnerLotto winnerLottoCreator() {
        WinnerLotto winnerLotto;
        try {
            winnerLotto = WinnerLotto.of(InputView.winnigLotto(), InputView.bonusLotto());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winnerLottoCreator();
        }
        return winnerLotto;
    }

    public static LottoFactory Try(int input) {
        int manualCount;
        try {
            manualCount = InputView.manualCount(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Try(input);
        }
        return makeLotto(input,manualCount);
    }

    private static LottoFactory makeLotto(int count, int manualCount) {
        List<List> manualString = new ArrayList<>();
        System.out.println("\n수동 로또를 입력해 주세요");
        for (int i = 0; i < manualCount; i++) {
            manualString.add(InputView.manualLotto());
        }
        System.out.println("\n수동 "+ manualCount + "개 자동 " +  (count - manualCount) + "개를 구매 하셨습니다.");
        return new LottoFactory(manualString, count - manualCount);
    }
}
