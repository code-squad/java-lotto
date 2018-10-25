package controller;

import domain.Lotto;
import domain.LottoFactory;
import view.InputView;

import java.util.List;

public class LottoGame {

    public static int inputMoney() {
        int input;
        try {
            input = InputView.input();
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return inputMoney();
        }
        return input;
    }

    public static LottoFactory autoLottoTry(int input) {
        System.out.println(InputView.lottoSize(input) + "개를 구매 하셨습니다.");
        return new LottoFactory(InputView.lottoSize(input));
    }

    public static Lotto winnerLottoCreator() {
        Lotto winnerLotto;
        try {
            List<String> input = InputView.lotto();
            winnerLotto = Lotto.winnerLottoCreator(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winnerLottoCreator();
        }
        return winnerLotto;
    }
}
