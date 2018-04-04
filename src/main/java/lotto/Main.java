package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.view.Output;
import lotto.view.UserPrompt;

import java.util.List;

import static lotto.view.ManualGenerator.*;
import static lotto.view.AutoGenerator.*;

public class Main {

//    public static void main(String[] args) {
//        Lotto lotto = initLotto();
//        showReceipt(lotto);
//
//        WinningLotto winningLotto = initWinningLotto();
//        getResult(lotto, winningLotto);
//    }
//
//    private static Lotto initLotto() {
//
//        int total = UserPrompt.getTotalNumberOfTickets();
//        int numberOfManual = UserPrompt.getNumberOfManual(total);
//        List<List<Integer>> manual = UserPrompt.promptManual(numberOfManual);
//
//        List<Ticket> autoTickets = getAutoTickets(total - numberOfManual);
//        List<Ticket> manualTickets = getManualTickets(manual);
//
//        return new Lotto(autoTickets, manualTickets);
//    }

//    private static WinningLotto initWinningLotto() {
//        try {
//            String ticket = UserPrompt.getWinningNumbers();
//            int number = UserPrompt.getBonusNumber();
//
//            Ticket winningTicket = generateWinningTicket(ticket);
//            Number bonusNumber = generateBonusNumber(number);
//
//            return new WinningLotto(winningTicket, bonusNumber);
//        } catch (IllegalArgumentException e) {
//            return initWinningLotto();
//        }
//    }

    private static void showReceipt(Lotto lotto) {
        Output.showPurchase(lotto);
    }

    private static void getResult(Lotto lotto, WinningLotto winningLotto) {
        Output.getResult(lotto, winningLotto);
    }
}