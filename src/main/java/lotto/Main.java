package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.view.Output;
import lotto.view.UserPrompt;

public class Main {

    public static void main(String[] args) {
        Lotto lotto = initLotto();
        showReceipt(lotto);

        WinningLotto winningLotto = initWinningLotto();
        getResult(lotto, winningLotto);
    }

    private static Lotto initLotto() {
        return new Lotto(UserPrompt.getUserTickets());
    }

    private static WinningLotto initWinningLotto() {
        Ticket winningTicket = UserPrompt.getWinningTicket();
        Number bonusNumber = UserPrompt.getBonusNumber(winningTicket);
        
        return new WinningLotto(winningTicket, bonusNumber);
    }

    private static void showReceipt(Lotto lotto) {
        Output.showPurchase(lotto);
    }

    private static void getResult(Lotto lotto, WinningLotto winningLotto) {
        Output.getResult(lotto, winningLotto);
    }
}