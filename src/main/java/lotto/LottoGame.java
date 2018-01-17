package lotto;


import lotto.domain.LottoCustomerTicket;
import lotto.domain.LottoManualTicketRequest;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    private InputView inputView;
    private ResultView resultView;

    private LottoGame() {
        this.resultView = new ResultView();
        this.inputView = new InputView();
    }

    private void start() {
        int ticketTotalPrice = inputView.requestToInputTicketTotalPrice();
        int manualTicketCount = inputView.requestToInputCountOfManualTicket();

        LottoManualTicketRequest lottoManualTicketRequest = inputView.requestToInputManualTickets(manualTicketCount);
        LottoCustomerTicket lottoCustomerTicket = LottoStore.buyLottoTicket(ticketTotalPrice, lottoManualTicketRequest);
        resultView.printTickets(lottoCustomerTicket);

        String successNumberString = inputView.requestToInputLastWeekSuccessNumbers();
        String bonusNumberString = inputView.requestToInputLastWeekBonusNumber();
        WinningLotto winningLotto = new WinningLotto(successNumberString, bonusNumberString);

        LottoResult lottoResult = lottoCustomerTicket.matchTickets(winningLotto);
        resultView.printResult(lottoResult);
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
