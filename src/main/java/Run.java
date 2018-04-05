import input.Input;
import lotto.*;
import result.Result;
import view.View;

public class Run {
    public static void main(String [] args) {
        int inputMoney = Input.inputMoney();
        int manualNumber = Input.manualBuyNumber();
        BuyLotto buy = new BuyLotto((inputMoney - (manualNumber * 1000)));
        View.printLottos(buy.manualBuy(manualNumber));
        View.showNumbers(inputMoney, manualNumber);
        Lotto winningNumber = Input.winningInput();
        int bonusNumber = Input.bonusNumberInput();
        LottoGame game = new LottoGame(buy.getLottos());
        WinningLotto lotto = new WinningLotto(winningNumber, bonusNumber);
        Result result = game.match(lotto);
        View.printResult(result);
    }
}
