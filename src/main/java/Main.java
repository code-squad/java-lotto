import domain.LottoSeller;
import domain.Lottos;
import domain.WinningLottos;
import domain.WinningNumbers;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoSeller seller = new LottoSeller();
        Lottos lottos = seller.buyRandomNumberLottos(purchaseAmount);
        ResultView.printLottos(lottos);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();

        WinningLottos results = lottos.match(winningNumbers);
        ResultView.printLottoResults(results);
    }
}
