package domain;

import View.InputView;

public class LottoMain {
    public static void main(String[] args) {
        int ticketCount = InputView.getTicketCount(InputView.getPurchaseFee());
        LottoMachine lottoMachine = new LottoMachine(ticketCount);
        lottoMachine.getMatch(InputView.getWinningNumber());
        System.out.println(LottoResult.printResult());
    }
}
