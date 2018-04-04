import input.Input;
import lotto.BuyLotto;
import lotto.Lotto;
import lotto.LottoGame;
import view.View;

public class Run {
    public static void main(String [] args) {
        int inputMoney = Input.inputMoney();
        BuyLotto buy = new BuyLotto(inputMoney);
        View.printLottos(buy.getLottos());
        View.showNumbers(inputMoney);
        Lotto winningNumber = Input.winningInput();
        LottoGame game = new LottoGame();
//        View.resultView(game.getWinCounts(game.match(buy.getLottos(), winningNumber)));
    }
}
