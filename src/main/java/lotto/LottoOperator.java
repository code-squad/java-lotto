package lotto;

import lotto.domain.CustomerLottoTickets;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.util.TicketNumberParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoOperator {
    private List<Integer> successNumbers;

    public LottoOperator(String successNumberString) {
        this.successNumbers = TicketNumberParser.parse(successNumberString);

        if (successNumbers.size() != 6) {
            throw new IllegalArgumentException("successNumbers=" + successNumbers.toString());
        }
    }

    public List<Integer> getSuccessNumbers() {
        return successNumbers;
    }

    public LottoPrize match(LottoTicket lottoTicket) {
        int matchCount = 0;
        for (Integer successNumber : successNumbers) {
            if (lottoTicket.match(successNumber)) {
                matchCount++;
            }
        }
        return LottoPrize.letMeKnowPrize(matchCount);
    }

    public LottoResult match(CustomerLottoTickets customerLottoTickets, int ticketTotalPrice) {
        Map<LottoPrize, Integer> lottoPrizeResults = new HashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoPrizeResults.put(lottoPrize, 0);
        }

        for (LottoTicket lottoTicket : customerLottoTickets.getTickets()) {
            LottoPrize lottoPrize = match(lottoTicket);
            lottoPrizeResults.put(lottoPrize, lottoPrizeResults.get(lottoPrize) + 1);
        }
        return new LottoResult(lottoPrizeResults, ticketTotalPrice);
    }
}
