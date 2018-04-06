package domain;

import View.InputView;
import View.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        boolean validation = false;
        while (!validation) {
            try {
                int payment = InputView.getPayment();
                int totalCount = LottoMachine.getTotalCount(payment);
                int manualCount = InputView.getManualCount();

                LottoMachine lottoMachine = new LottoMachine();
                lottoMachine.createManualTickets(InputView.getManualNumber(manualCount));
                lottoMachine.createAutoTickets(LottoMachine.getAutoCount(totalCount, manualCount));

                ResultView.printAutoManualCount(totalCount, manualCount);
                System.out.println(lottoMachine.toString());

                Result result = lottoMachine.matching(InputView.getWinningNumber(), InputView.getBonusNumber(), payment);
                ResultView.printResult(result);
                validation = true;
            } catch (Exception e) {
                validation = false;
                System.out.println(e.getMessage());
            }
        }
    }
}