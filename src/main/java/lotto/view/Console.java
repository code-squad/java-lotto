package lotto.view;

import lotto.domain.*;

import java.util.List;

/**
 * @author sangsik.kim
 */
public class Console {
    public static void main(String[] args) {
        Money amount = InputView.getAmount();
        int customOrderCount = InputView.getCustomOrderCount();

        List<Lotto> customLottos = InputView.getCustomLottos(customOrderCount);
        LottoTicket lottoTickets = LottoProvider.order(amount, customLottos);

        ResultView.printLottos(lottoTickets, customOrderCount);

        WinningLotto winningLotto = InputView.getWinningLotto();
        LottoResult result = lottoTickets.createResult(winningLotto);
        ResultView.printResult(result);
    }
}
