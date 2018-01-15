package lotto;

import lotto.domain.Order;
import lotto.view.InputView;
import lotto.view.ResultView;

public class MainApplication {
    public static void main(String[] args) {
        int totalCost = InputView.getTotalCost();
        Order order = new Order(totalCost);
        order.purchase();

        ResultView.printLottos(order.getLottos());

        int[] luckyNumbers = InputView.getLuckyNumber();
        order.checkWinning(luckyNumbers);

        ResultView.printWinningResult(order.getLottos());
        ResultView.printEarningsRate(order);
    }
}
