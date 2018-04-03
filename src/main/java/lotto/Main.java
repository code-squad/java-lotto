package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Parser;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Lotto lotto = promptUserForPurchase();
        showReceipt(lotto);

        WinningLotto winningLotto = promptUserForWinningNumbers();
        getResult(lotto, winningLotto);
    }

    private static Lotto promptUserForPurchase() {
        Lotto lotto;
        try {
            Output.printMessage("구입 금액을 입력해 주세요.");
            int ticketsBought = Parser.getNumberOfTickets(Parser.parseToInt(Input.takeInput()));
            lotto = new Lotto(ticketsBought);

        } catch (IllegalArgumentException e) {
            return promptUserForPurchase();
        }
        return lotto;
    }

    private static WinningLotto promptUserForWinningNumbers() {
        WinningLotto winningLotto;
        try {
            Output.printMessage("지난 주 당첨 번호를 입력해 주세요.");
            List<Number> winningNumbers = Parser.parseToNumberArray(Parser.splitString(Input.takeInput()));

            Output.printMessage("보너스 볼을 입력해 주세요.");
            Number bonusNumber = Parser.parseToNumber(Parser.parseToInt(Input.takeInput()));

            WinningLotto.checkDuplicate(winningNumbers, bonusNumber);
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        } catch (IllegalArgumentException e) {
            return promptUserForWinningNumbers();
        }
        return winningLotto;
    }

    private static void showReceipt(Lotto lotto) {
        Output.showPurchase(lotto);
    }

    private static void getResult(Lotto lotto, WinningLotto winningLotto) {
        Output.getResult(lotto, winningLotto);
    }
}