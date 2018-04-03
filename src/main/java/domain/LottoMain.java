package domain;

import View.InputView;

public class LottoMain {
    public static void main(String[] args) {
        boolean validation = false;
        LottoMachine lottoMachine = null;
        int purchaseFee = InputView.getPurchaseFee();
        while (!validation) {
            try {
                lottoMachine = new LottoMachine(InputView.getTicketCount(purchaseFee));
                lottoMachine.getMatch(InputView.getWinningNumber());
                validation = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                validation = false;
            }
        }
        LottoResult lottoResult = LottoResult.getInstance();
        lottoResult.calcRateOfProfit(purchaseFee);
        System.out.println(lottoResult.printResult());
    }
}