import domain.Lotto;
import domain.LottoSeller;
import domain.WinningNumbers;
import dto.LottoResult;
import utils.RevenueCalculator;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoSeller seller = new LottoSeller();
        List<Lotto> lottos = seller.buyRandomNumberLottos(purchaseAmount);
        ResultView.printLottos(lottos);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();

        List<LottoResult> results = winningNumbers.match(lottos);
        ResultView.printLottoResults(results);
        ResultView.printRevenue(RevenueCalculator.calculate(results));
    }
}
