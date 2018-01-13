package lotto.view;

import lotto.domain.CustomerLottoTickets;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

public class ResultView {
    public void printTickets(CustomerLottoTickets lottoTickets) {
        System.out.println(lottoTickets.count() + "개를 구매했습니다.");

        for (LottoTicket lottoTicket : lottoTickets.getTickets()) {
            System.out.println(lottoTicket);
        }
    }

    /*
     당첨 통계
     ---------
     3개 일치 (5000원)- 1개
     4개 일치 (50000원)- 0개
     5개 일치 (1500000원)- 0개
     6개 일치 (2000000000원)- 0개

     총 수익률은 30%입니다.
     */
    public void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult.showResultMessage(LottoPrize.THREE));
        System.out.println(lottoResult.showResultMessage(LottoPrize.FOUR));
        System.out.println(lottoResult.showResultMessage(LottoPrize.FIVE));
        System.out.println(lottoResult.showResultMessage(LottoPrize.SIX));
        System.out.println("");
        System.out.println("총 수익률은 " + lottoResult.calculateProfitRatio() + "%입니다");
    }
}
