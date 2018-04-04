package domain;

import View.InputView;
import View.LottoResult;

import java.util.HashMap;
import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        boolean validation = false;
        LottoMachine lottoMachine = null;
        Map<Rank, Integer> result = new HashMap<>();
        int purchaseFee = InputView.getPurchaseFee();
        while (!validation) {
            try {
                lottoMachine = new LottoMachine(InputView.getTicketCount(purchaseFee));
                result = lottoMachine.matching(InputView.getWinningNumber(), InputView.getBonusNumber());
                validation = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                validation = false;
            }
        }
        LottoResult lottoResult = new LottoResult(result, purchaseFee);
        System.out.println(lottoResult.printResult());
    }
}