package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.view.*;

import java.util.List;

import static lotto.view.Generator.*;

public class Main {

    public static void main(String[] args) {
        Lotto lotto = initLotto();
        showReceipt(lotto);

        WinningLotto winningLotto = initWinningLotto();
        getResult(lotto, winningLotto);
    }

    private static Lotto initLotto() {
        try {
            int money = UserPrompt.getMoney();
            int numberOfManual = UserPrompt.getNumberOfManual();
            List<List<Integer>> manual = UserPrompt.getManual(numberOfManual);

            return new Lotto(generateAutoTickets(total - numberOfManual), generateManualTickets(manual));

        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return initLotto();
        }
    }

    private static WinningLotto initWinningLotto() {
        try {
            List<Integer> numbers = UserPrompt.getWinningNumbers();
            Integer number = UserPrompt.getBonusNumber();

            Ticket winningTicket = generateWinningTicket(numbers);
            Number bonusNumber = generateBonusNumber(number);
            return new WinningLotto(winningTicket, bonusNumber);

        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return initWinningLotto();
        }
    }

    private static void showReceipt(Lotto lotto) {
        Output.showPurchase(lotto);
    }

    private static void getResult(Lotto lotto, WinningLotto winningLotto) {
        Output.getResult(lotto, winningLotto);
    }
}