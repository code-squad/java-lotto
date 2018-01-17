package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

/**
 * Created by Moonchan on 2018. 1. 13..
 */
public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoGame lottoGame = new LottoGame();
        
        int money = inputView.inputMoney();
        int ticketCount = lottoGame.buyTicket(money);
        printTicketCount(ticketCount);
        printTicket(lottoGame.getTicketsString());
        LottoNumber winningNumber = inputView.inputWinningNumber();
        LottoResult lottoResult = lottoGame.getPrizeResult(winningNumber);
        ResultView resultView = new ResultView(lottoResult);
        resultView.printReport();
    }

    private static void printTicketCount(int ticketCount) {
        System.out.println(String.format("%d개를 구매했습니다.", ticketCount));
    }

    private static void printTicket(String ticketsString) {
        System.out.println(ticketsString);
    }
}
