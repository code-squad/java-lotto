package domain;

import io.InputView;
import io.ResultView;
import utils.Utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hoon on 2018. 1. 14..
 */
public class Main {
    public static void main(String[] args) {

        Integer totalTicketCount = InputView.readMoney();
        Integer manualTicketCount = InputView.readNumberOfTicketByManual();
        Integer autoTicketCount = totalTicketCount - manualTicketCount;

        List<Ticket> manualTickets = Ticket.generateManualTickets(manualTicketCount);
        List<Ticket> autoTickets = Ticket.generateAutoTickets(autoTicketCount);

        ResultView.printTicketCount(autoTicketCount, manualTicketCount);
        ResultView.printTickets(Stream.concat(autoTickets.stream(), manualTickets.stream())
                .collect(Collectors.toList()));

        WinningTicket winningTicket = new WinningTicket(Utils.toIntegerList(Utils.splitWithDelimiter(InputView.readWinningNumbers(), ", ")), InputView.readBonusNumber());

        Lotto lotto = new Lotto(Stream.concat(autoTickets.stream(), manualTickets.stream()).collect(Collectors.toList()), winningTicket);

        ResultView.printResult(lotto);


    }
}