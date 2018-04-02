package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Parser;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Lotto lotto = new Lotto(promptUserForPurchase());

        showReceipt(lotto);

        displayResult(lotto, promptUserForWinningNumbers());
    }

    private static int promptUserForPurchase() {
        int ticketsBought;
        try {
            Output.printMessage("구입 금액을 입력해 주세요.");
            ticketsBought = Parser.getNumberOfTickets(Parser.parseToInt(Input.takeInput()));
        } catch (IllegalArgumentException e) {
            return promptUserForPurchase();
        }
        return ticketsBought;
    }

    private static List<Number> promptUserForWinningNumbers() {
        List<Number> winningNumbers;
        try {
            Output.printMessage("지난 주 당첨 번호를 입력해 주세요.");
            winningNumbers = Parser.parseToNumberArray(Parser.splitString(Input.takeInput()));

            Output.printMessage("보너스 볼을 입력해 주세요.");
            Number bonusNumber = Parser.parseToNumber(Parser.parseToInt(Input.takeInput()));

            winningNumbers = Parser.checkDuplicate(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            return promptUserForWinningNumbers();
        }
        return winningNumbers;
    }

    private static void showReceipt(Lotto lotto) {
        Output.showPurchase(lotto);
    }

    private static void displayResult(Lotto lotto, List<Number> winningNumbers) {
        Output.showResult(lotto, winningNumbers);
    }
}