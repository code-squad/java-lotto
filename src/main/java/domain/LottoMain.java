package domain;

import View.InputView;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseFee = InputView.getPurchaseFee();
        int ticketCount = InputView.getTicketCount(purchaseFee);
        LottoMachine lottoMachine = new LottoMachine(ticketCount);
        lottoMachine.getMatch(InputView.getWinningNumber());
        LottoResult.calcRateOfProfit(purchaseFee);
        System.out.println(LottoResult.printResult());
    }
}
