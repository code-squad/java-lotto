import domain.LottoBundle;
import domain.WinningLotto;
import domain.result.LottoResults;
import view.InputView;
import view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputView.getPurchaseAmount();
        LottoBundle lottoBundle = new LottoBundle(amount);
        OutputView.printPurchaseHistory(lottoBundle);

        WinningLotto winningNumber = InputView.getWinningNumber();
        LottoResults results = lottoBundle.matchLotto(winningNumber);
        OutputView.printResult(amount, results);
    }
}