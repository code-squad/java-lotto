package lotto;

import lotto.domain.Lotto;
import lotto.domain.Order;
import lotto.domain.WinningLotto;
import lotto.dto.WinningDTO;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        int totalCost = InputView.getTotalCost();
        Order order = new Order(totalCost);
        List<Lotto> lottos = order.purchase();

        ResultView.printLottos(lottos);

        List<Integer> luckyNumbers = InputView.getLuckyNumber();
        int bonus = InputView.getBonus(luckyNumbers);
        WinningDTO winningResult = order.checkWinning(new WinningLotto(luckyNumbers, bonus));

        ResultView.printWinningResult(winningResult);

    }
}
