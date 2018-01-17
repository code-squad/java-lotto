package lotto;

import lotto.domain.Order;
import lotto.dto.WinningDTO;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        int totalCost = InputView.getTotalCost();
        Order order = new Order(totalCost);
        order.purchase();

        ResultView.printLottos(order.getLottos());

        List<Integer> luckyNumbers = InputView.getLuckyNumber();
        WinningDTO winningResult = order.checkWinning(luckyNumbers);

        ResultView.printWinningResult(winningResult);

    }
}
