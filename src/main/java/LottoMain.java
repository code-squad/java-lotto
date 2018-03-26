import domain.LottoBundle;
import domain.LottoWiningNum;
import dto.LottoResult;
import view.InputView;
import view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputView.getPurchaseAmount();
        LottoBundle lottoBundle = new LottoBundle(amount);
        OutputView.printPurchaseHistory(lottoBundle);
        LottoWiningNum winningNumber = InputView.getWinningNumber();
        LottoResult result = lottoBundle.matchLotto(winningNumber);
        OutputView.printResult(result);
    }
}