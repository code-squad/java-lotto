import input.InputMoney;
import input.InputWinning;
import lotto.BuyLotto;
import lotto.Lotto;
import lotto.LottoGame;
import view.view;

public class Run {
    public static void main(String [] args) {
        int inputMoney = InputMoney.inputMoney();
        BuyLotto buy = new BuyLotto(inputMoney);
        view.showNumbers(inputMoney);
        Lotto winningNumber = InputWinning.winningInput();
        view.resultView(buy.getLottos() ,winningNumber);
    }
}
