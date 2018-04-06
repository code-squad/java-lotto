package domain;

import View.InputView;
import View.ResultView;

import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        boolean validation = false;
        while(!validation) {
            try {
                int payment = InputView.getPayment();
                int totalCount = LottoMachine.getTotalCount(payment);
                int manualCount = InputView.getManualCount();
                LottoMachine lottoMachine = new LottoMachine();
                lottoMachine.getManualTickets(InputView.getManualNumber(manualCount));
                lottoMachine.getAutoTickets(LottoMachine.getAutoCount(totalCount, manualCount));
                ResultView.printAutoManualCount(totalCount, manualCount);
                System.out.println(lottoMachine.toString());
                Map<Rank, Integer> rankCount = lottoMachine.matching(InputView.getWinningNumber(), InputView.getBonusNumber());
                Result result = new Result(rankCount, payment);
                ResultView.printResult(result);
                validation = true;
            }catch (Exception e) {
                validation = false;
                System.out.println(e.getMessage());
            }
        }
    }
}