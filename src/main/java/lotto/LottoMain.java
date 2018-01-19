package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

/**
 * Created by Moonchan on 2018. 1. 13..
 */
public class LottoMain {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        lottoGame.buyTicket(InputView.inputMoney(), InputView.inputManualLottoNumbers());
        printTicketCount(lottoGame);
        printEmptyLine();
        printTicket(lottoGame.getTicketsString());
        printEmptyLine();
        ResultView.printReport(lottoGame.getPrizeResult(InputView.inputWinningNumber()));
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printTicketCount(LottoGame lottoGame) {
        int countManual = lottoGame.getLottoTicketCountBySource(LottoTicket.Source.MANUAL);
        int countAuto = lottoGame.getLottoTicketCountBySource(LottoTicket.Source.AUTO);
        System.out.println(String.format("수동으로 %d개, 자동으로 %d개를 구매했습니다.", countManual, countAuto));
    }

    private static void printTicket(String ticketsString) {
        System.out.println(ticketsString);
    }
}
