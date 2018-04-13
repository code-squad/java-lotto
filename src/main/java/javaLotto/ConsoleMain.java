package javaLotto;

import javaLotto.domain.*;
import javaLotto.view.InputView;
import javaLotto.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) throws Exception {

        int price = Integer.parseInt(InputView.setPrice());
        Lotto lotto = JavaLotto.buyLotto(price);
        ResultView.buyLottoInfoPrint(lotto);

        String winningNumber = InputView.setWinningNumber();
        String bonusNumber = InputView.setBonusNumber();

        GameResult result = Grade.checkGrade(lotto, new WinningNumber(winningNumber, bonusNumber));
        ResultView.resultPrint(result, price);

    }
}
