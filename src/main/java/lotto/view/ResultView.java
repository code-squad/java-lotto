package lotto.view;

import lotto.domain.LottoCustomerTicket;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import org.apache.commons.lang3.StringUtils;

public class ResultView {
    public void printTickets(LottoCustomerTicket lottoTickets) {
        System.out.println(lottoTickets.showCountMessage());

        for (String message : lottoTickets.showTicketMessages()) {
            System.out.println(message);
        }
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println(LottoResult.MESSAGE_HEADER);
        System.out.println(LottoResult.MESSAGE_HEADER_LINE);
        System.out.println(lottoResult.showResultMessage(LottoPrize.THREE));
        System.out.println(lottoResult.showResultMessage(LottoPrize.FOUR));
        System.out.println(lottoResult.showResultMessage(LottoPrize.FIVE));
        System.out.println(lottoResult.showResultMessage(LottoPrize.FIVE_BONUS));
        System.out.println(lottoResult.showResultMessage(LottoPrize.SIX));
        System.out.println(StringUtils.EMPTY);
        System.out.println(lottoResult.showProfitRatioResultMessage());
    }

}
