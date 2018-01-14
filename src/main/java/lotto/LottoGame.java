package lotto;


import lotto.domain.LottoCustomer;
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

        LottoCustomer lottoCustomer = LottoStore.buyRandomTickets(LottoStore.countTicket(ticketTotalPrice));
        resultView.printTickets(lottoCustomer);

        LottoOperator lottoOperator = new LottoOperator(inputView.requestToInputLastWeekSuccessNumbers());
        LottoResult lottoResult = lottoCustomer.matchTickets(lottoOperator);

        resultView.printResult(lottoResult);
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
