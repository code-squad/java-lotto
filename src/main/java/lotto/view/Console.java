package lotto.view;

import lotto.domain.*;

/**
 * @author sangsik.kim
 */
public class Console {
    public static void main(String[] args) {
        LottoTicket lottoTickets = LottoProvider.order(InputView.getAmount());
        ResultView.printLottos(lottoTickets);

        WinningLotto winningLotto = InputView.getWinningLotto();

        LottoResult result = lottoTickets.createResult(winningLotto);
        ResultView.printResult(result);
    }
}
