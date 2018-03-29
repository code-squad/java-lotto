import domain.LottoBundle;
import domain.WinningLotto;
import domain.result.LottoResults;
import utils.LottoMachine;
import view.InputView;
import view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputView.getBuyAmount();
        LottoBundle lottoBundle = new LottoBundle(LottoMachine.autoBuy(amount));
        OutputView.printPurchaseHistory(lottoBundle);

        WinningLotto winningNumber = InputView.getWinningLotto();
        LottoResults results = lottoBundle.matchLotto(winningNumber);
        OutputView.printResult(amount, results);
    }
}