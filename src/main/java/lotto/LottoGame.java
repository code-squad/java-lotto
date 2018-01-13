package lotto;


import lotto.domain.CustomerLottoTickets;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    private InputView inputView;
    private ResultView resultView;

    public LottoGame() {
        this.resultView = new ResultView();
        this.inputView = new InputView();
    }

    public void start() {
        int ticketTotalPrice = inputView.requestToInputTicketTotalPrice();

        CustomerLottoTickets customerLottoTickets = LottoStore.buyRandomTickets(LottoStore.countTicket(ticketTotalPrice));
        resultView.printTickets(customerLottoTickets);

        LottoOperator lottoOperator = new LottoOperator(inputView.requestToInputLastWeekSuccessNumbers());
        LottoResult lottoResult = lottoOperator.match(customerLottoTickets, ticketTotalPrice);

        resultView.printResult(lottoResult);
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
