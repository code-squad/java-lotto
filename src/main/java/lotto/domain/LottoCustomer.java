package lotto.domain;

import lotto.LottoOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCustomer {
    private List<LottoTicket> tickets;

    public LottoCustomer(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public LottoResult matchTickets(LottoOperator lottoOperator) {
        Map<LottoPrize, Integer> lottoPrizeResults = new HashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoPrizeResults.put(lottoPrize, 0);
        }

        for (LottoTicket lottoTicket : tickets) {
            LottoPrize lottoPrize = lottoOperator.match(lottoTicket);
            lottoPrizeResults.put(lottoPrize, lottoPrizeResults.get(lottoPrize) + 1);
        }
        return new LottoResult(lottoPrizeResults, tickets.size() * LottoConstants.UNIT_PRICE);
    }

    public String showCountMessage() {
        return tickets.size() + "개를 구매했습니다.";
    }

    public List<String> showTicketMessages() {
        List<String> messages = new ArrayList<>();
        for (LottoTicket lottoTicket : tickets) {
            messages.add(lottoTicket.toString());
        }
        return messages;
    }
}
