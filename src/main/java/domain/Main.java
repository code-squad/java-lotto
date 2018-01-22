package domain;

import io.InputView;
import io.ResultView;
import utils.Utils;

import java.util.List;

/**
 * Created by hoon on 2018. 1. 14..
 */
public class Main {
    public static void main(String[] args) {

        List<Ticket> tickets = Ticket.generateTickets(Lotto.getTicketCount(InputView.readMoney()));

        ResultView.printTickets(tickets);

        Ticket ticket = new Ticket(Utils.toIntegerList(Utils.splitWithDelimiter(InputView.readWinningNumbers(), ", ")));

        Lotto lotto = new Lotto(tickets, ticket);

        ResultView.printResult(lotto);
    }
}