package lotto.domain;

import lotto.WinningLotto;

import java.util.*;

public class LottoCustomerTicket {
    private List<LottoTicket> tickets;
    private int randomTicketCount = 0;
    private int explicitTicketCount = 0;

    public LottoCustomerTicket(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public LottoCustomerTicket(LottoCustomerTicket customerRandomTickets, LottoCustomerTicket customerExplicitTickets) {
        List<LottoTicket> randomTickets = customerRandomTickets.getTickets();
        List<LottoTicket> explicitTickets = customerExplicitTickets.getTickets();

        this.tickets = new ArrayList<>();
        tickets.addAll(randomTickets);
        tickets.addAll(explicitTickets);
        this.randomTicketCount = randomTickets.size();
        this.explicitTicketCount = explicitTickets.size();
    }

    public LottoResult matchTickets(WinningLotto winningLotto) {
        Map<LottoPrize, Integer> lottoPrizeResults = new HashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoPrizeResults.put(lottoPrize, 0);
        }

        for (LottoTicket lottoTicket : tickets) {
            LottoPrize lottoPrize = winningLotto.match(lottoTicket);
            lottoPrizeResults.put(lottoPrize, lottoPrizeResults.get(lottoPrize) + 1);
        }
        return new LottoResult(lottoPrizeResults, tickets.size() * LottoConstants.UNIT_PRICE);
    }

    public String showCountMessage() {
        return "수동으로 " + explicitTicketCount + "장, 자동으로 " + randomTicketCount + "장을 구매했습니다.";
    }

    public List<String> showTicketMessages() {
        List<String> messages = new ArrayList<>();
        for (LottoTicket lottoTicket : tickets) {
            messages.add(lottoTicket.toString());
        }
        return messages;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoTicket ticket : tickets) {
            sb.append(ticket.toPlainString());
            sb.append(LottoConstants.NEW_LINE);
        }
        return sb.toString();
    }
}
