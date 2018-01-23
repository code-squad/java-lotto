package lotto;

import lotto.domain.Order;
import lotto.domain.WinningLotto;
import lotto.dto.WinningDTO;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        int totalCost = InputView.getTotalCost();
        int customCount = InputView.getCustomCount();
        List<String> customNumbers = InputView.getCustomNumber(customCount);
        Order order = new Order(totalCost, customNumbers);

        ResultView.printLottos(order);

        String luckyNumbers = InputView.getLuckyNumber();
        int bonus = InputView.getBonus();
        WinningDTO winningResult = order.checkWinning(new WinningLotto(luckyNumbers, bonus));

        ResultView.printWinningResult(winningResult);

    }
}
