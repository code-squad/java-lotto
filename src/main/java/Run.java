import input.Input;
import lotto.BuyLotto;
import lotto.Lotto;
import lotto.LottoGame;
import lotto.WinningLotto;
import result.Result;
import view.View;

public class Run {
    public static void main(String [] args) {
        int inputMoney = Input.inputMoney();
        BuyLotto buy = new BuyLotto(inputMoney);
        View.printLottos(buy.getLottos());
        View.showNumbers(inputMoney);
        Lotto winningNumber = Input.winningInput();
        int bonusNumber = Input.bonusNumberInput();
        LottoGame game = new LottoGame(buy.getLottos());
        WinningLotto lotto = new WinningLotto(winningNumber, bonusNumber);
        Result result = game.match(lotto);
//        View.resultView(result.insert(game.match(buy.getLottos(), winningNumber, bonusNumber)));
//        View.printProfit(game.match(buy.getLottos(), winningNumber, bonusNumber));
    }
}
