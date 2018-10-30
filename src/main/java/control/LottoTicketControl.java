package control;

import utils.MathHandler;
import view.InputView;

import static view.ResultView.NEWLINE;

public class LottoTicketControl {

    public static int getLottoTicketCount() {
        while (true) {
            int lottoTicketCount = MathHandler.getLottoTicketNum(InputView.inputPurchaseAmount());
            if (lottoTicketCount < 1) {
                System.out.println("[돈이 모자랍니다.]" + NEWLINE);
                getLottoTicketCount();
            }
            return lottoTicketCount;
        }
    }

    public static int getManualLottoTicketCount(int lottoTicketCount) {
        while (true) {
            int manualLottoCount = InputView.inputManualLottoCount();
            if (lottoTicketCount < manualLottoCount || manualLottoCount < 0) {
                System.out.println("[수동 입력 로또 수가 적절하지 않습니다.]");
                getManualLottoTicketCount(lottoTicketCount);
            }
            return manualLottoCount;
        }
    }
}