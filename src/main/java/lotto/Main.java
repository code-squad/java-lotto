package lotto;

import lotto.domain.*;
import lotto.domain.generation.Number;
import lotto.domain.generation.Ticket;
import lotto.view.*;

import java.util.List;

import static lotto.domain.generation.Generator.*;

public class Main {

    public static void main(String[] args) {
        Lotto lotto = initLotto();
        showReceipt(lotto);

        WinningLotto winningLotto = initWinningLotto();
        getResult(lotto, winningLotto);
    }

    private static Lotto initLotto() {
        try {
            String money = UserPrompt.promptPurchase();
            String numberOfManual = UserPrompt.promptNumberOfManual();
            String manualTickets = UserPrompt.promptManual(numberOfManual);

            List<Ticket> manual = generateManualTickets(manualTickets, money);
            List<Ticket> auto = generateAutoTickets(manual.size(), money);

            return new Lotto(auto, manual);

        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return initLotto();
        }
    }

    private static WinningLotto initWinningLotto() {
        try {
            String winningNumbers = UserPrompt.promptWinningNumbers();
            String bonus = UserPrompt.promptBonusNumber();

            Ticket winningTicket = generateWinningTicket(winningNumbers);
            Number bonusNumber = generateBonusNumber(bonus);
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