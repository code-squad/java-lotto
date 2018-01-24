package domain;

import io.*;
import utils.*;

import java.util.List;

/**
 * Created by hoon on 2018. 1. 14..
 */
public class Main {
    public static void main(String[] args) {

        List<Ticket> tickets = Ticket.generateTickets(Lotto.getTicketCount(InputView.readMoney()));

        ResultView.printTickets(tickets);

        Ticket winningTicket = new Ticket(Utils.toIntegerList(Utils.splitWithDelimiter(InputView.readWinningNumbers(), ", ")));

        Integer bonusNumber = InputView.readBonusNumber();

        Lotto lotto = new Lotto(tickets, winningTicket, bonusNumber);

        ResultView.printResult(lotto);
    }
}