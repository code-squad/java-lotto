package control;

import utils.MathHandler;
import view.InputView;

import static view.ResultView.NEWLINE;

public class LottoTicketControl {

    public static int getLottoTicketCount() {
        while (true) {
            try {
                int lottoTicketCount = MathHandler.getLottoTicketNum(InputView.inputPurchaseAmount());
                if (lottoTicketCount > 0) {
                    return lottoTicketCount;
                }
                throw new IllegalArgumentException();
            } catch (Exception e) {
                System.out.println("[구입 금액 입력이 적절하지 않습니다]" + NEWLINE);
            }
        }
    }

    public static int getManualLottoTicketCount(int lottoTicketCount) {
        while (true) {
            try {
                int manualLottoCount = InputView.inputManualLottoCount();
                if (lottoTicketCount >= manualLottoCount && manualLottoCount >= 0) {
                    return manualLottoCount;
                }
                throw new IllegalArgumentException();
            } catch (Exception e) {
                System.out.println("[수동 입력 로또 수가 적절하지 않습니다.]");
            }
        }
    }
}