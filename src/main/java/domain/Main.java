package domain;

import io.InputView;
import io.ResultView;
import utils.Utils;

import java.util.List;

import static constant.Constant.LOTTO_PRICE;

/**
 * Created by hoon on 2018. 1. 14..
 */
public class Main {
    public static void main(String[] args) {

        Integer money = InputView.readMoney();
        Integer manualTicketCount = InputView.readNumberOfTicketByManual();

        List<Ticket> manualTickets = Ticket.generateManualTickets(manualTicketCount);
        WinningTicket winningTickets = new WinningTicket(Utils.toIntegerList(Utils.splitWithDelimiter(InputView.readWinningNumbers(), ", ")), InputView.readBonusNumber());
        Lotto lotto = new Lotto(manualTickets, money, winningTickets);

        ResultView.printTicketCount((money - (manualTicketCount*LOTTO_PRICE))/LOTTO_PRICE, manualTicketCount);
        ResultView.printTickets(lotto.getTotalTickets());

        ResultView.printResult(lotto);

    }
}