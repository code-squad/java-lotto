package javaLotto;

import javaLotto.domain.*;
import javaLotto.view.InputView;
import javaLotto.view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) throws Exception {

        int price = Integer.parseInt(InputView.setPrice());
        int manualBuyCount = Integer.parseInt(InputView.setManual());
        List<LottoTicket> manualTicket = InputView.setManualNumber(manualBuyCount,price);

        Lotto lotto = JavaLotto.buyLotto(price, manualTicket);
        ResultView.buyLottoInfoPrint(lotto, manualBuyCount);

        String winningNumber = InputView.setWinningNumber();
        String bonusNumber = InputView.setBonusNumber();

        GameResult result = Grade.checkGrade(lotto, new WinningNumber(winningNumber, bonusNumber));
        ResultView.resultPrint(result, price);

    }
}
