import domain.LottoBundle;
import domain.WinningLotto;
import domain.result.LottoResults;
import utils.LottoMachine;
import view.InputView;
import view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        int totalAmount = InputView.getTotalAmount();
        int manualAmount = InputView.getManualBuyAmount(totalAmount);

        LottoBundle lottoBundle = LottoBundle.of();
        lottoBundle.addLotto(InputView.getManualLottoBundle(manualAmount));
        lottoBundle.addLotto(LottoMachine.autoBuy(totalAmount, manualAmount));









        /*LottoBundle lottoBundle = new LottoBundle(LottoMachine.autoBuy(amount));
        OutputView.printPurchaseHistory(lottoBundle);

        WinningLotto winningNumber = InputView.getWinningLotto();
        LottoResults results = lottoBundle.matchLotto(winningNumber);
        OutputView.printResult(amount, results);*/
    }
}