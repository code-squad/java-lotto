import domain.Lotto;
import domain.LottoBundle;
import view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputView.getPurchaseAmount();
        LottoBundle lottoBundle = new LottoBundle(amount);
        Lotto winningNumber = InputView.getWinningNumber();
    }


}