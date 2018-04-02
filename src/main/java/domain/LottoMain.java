package domain;

import View.InputView;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseFee = InputView.getPurchaseFee();
        LottoMachine lottoMachine = new LottoMachine(InputView.getTicketCount(purchaseFee));
        lottoMachine.getMatch(InputView.getWinningNumber());
        LottoResult lottoResult = LottoResult.getInstance();
        lottoResult.calcRateOfProfit(purchaseFee);
        System.out.println(lottoResult.printResult());
    }
}
