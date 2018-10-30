package control;

import domain.LottoRules;
import utils.MathHandler;
import view.InputView;

public class LottoTicketControl {

    public static int getLottoTicketCount() {
        while (true) {
            try {
                return LottoRules.checkLottoTicketCount(MathHandler.getLottoTicketNum(InputView.inputPurchaseAmount()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public static int getManualLottoTicketCount(int lottoTicketCount) {
        while (true) {
            try {
                return LottoRules.checkManualLottoCount(lottoTicketCount, InputView.inputManualLottoCount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}