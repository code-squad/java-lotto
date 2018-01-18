package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

/**
 * Created by Moonchan on 2018. 1. 13..
 */
public class LottoMain {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        printTicketCount(lottoGame.buyTicket(InputView.inputMoney()));
        printEmptyLine();
        printTicket(lottoGame.getTicketsString());
        printEmptyLine();
        ResultView.printReport(lottoGame.getPrizeResult(InputView.inputWinningNumber()));
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printTicketCount(int ticketCount) {
        System.out.println(String.format("%d개를 구매했습니다.", ticketCount));
    }

    private static void printTicket(String ticketsString) {
        System.out.println(ticketsString);
    }
}
