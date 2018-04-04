package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.view.Output;
import lotto.view.UserPrompt;

import java.util.List;

import static lotto.view.ManualGenerator.generateWinningTicket;
import static lotto.view.ManualGenerator.getManualTickets;
import static lotto.view.AutoGenerator.getAutoTickets;

public class Main {

    public static void main(String[] args) {
        Lotto lotto = initLotto();
        showReceipt(lotto);

        WinningLotto winningLotto = initWinningLotto();
        getResult(lotto, winningLotto);
    }

    private static Lotto initLotto() {
        int total = UserPrompt.getTotalNumberOfTickets();
        int numberOfManual = UserPrompt.getNumberOfManual(total);
        String manual = UserPrompt.promptManual(numberOfManual);

        return new Lotto(getAutoTickets(numberOfManual), getManualTickets(manual));
    }

    private static WinningLotto initWinningLotto() {
        try {
            String ticket = UserPrompt.getWinningNumbers();
            int ball = UserPrompt.getBonusNumber();

            Ticket winningTicket = getManualTickets(ticket);
            Number bonusNumber = UserPrompt.getBonusNumber(winningTicket);
            return new WinningLotto(winningTicket, bonusNumber);
        } catch (IllegalArgumentException e) {
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