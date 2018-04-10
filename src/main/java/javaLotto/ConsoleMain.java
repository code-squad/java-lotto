package javaLotto;

import javaLotto.domain.Grade;
import javaLotto.domain.JavaLotto;
import javaLotto.domain.Lotto;
import javaLotto.domain.WinningNumber;
import javaLotto.view.InputView;
import javaLotto.view.ResultView;
import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) throws Exception {

        int price = Integer.parseInt(InputView.setPrice());
        Lotto lotto = JavaLotto.buyLotto(price);
        ResultView.buyLottoInfoPrint(lotto);

        String winningNumber = InputView.setWinningNumber();
        List<Integer> result = Grade.checkGrade(lotto, new WinningNumber(winningNumber));

        ResultView.resultPrint(result, price);
    }

}
