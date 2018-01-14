package lotto.view;

import lotto.domain.LottoCustomer;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;

public class ResultView {
    public void printTickets(LottoCustomer lottoTickets) {
        System.out.println(lottoTickets.showCountMessage());

        for (String message : lottoTickets.showTicketMessages()) {
            System.out.println(message);
        }
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult.showResultMessage(LottoPrize.THREE));
        System.out.println(lottoResult.showResultMessage(LottoPrize.FOUR));
        System.out.println(lottoResult.showResultMessage(LottoPrize.FIVE));
        System.out.println(lottoResult.showResultMessage(LottoPrize.FIVE_BONUS));
        System.out.println(lottoResult.showResultMessage(LottoPrize.SIX));
        System.out.println("");
        System.out.println("총 수익률은 " + lottoResult.calculateProfitRatio() + "%입니다");
    }
}
