package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<LottoTicket> lottoTickets;
    private LottoResult lottoResult;

    public LottoMachine(int ticketCount) {
        lottoTickets = new ArrayList<>();
        makeLottoTickets(ticketCount);
        lottoResult = LottoResult.getInstance();
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public void getMatch(List<Integer> lastWinningNumber) {
        for (int index = 0; index < lottoTickets.size(); index++) {
            LottoTicket ticket = lottoTickets.get(index);
            lottoResult.isValid(countMatchedNumber(ticket, lastWinningNumber));
        }
    }

    public int countMatchedNumber(LottoTicket ticket, List<Integer> lastWinningNumber) {
        int matchedNumberCount = 0;
        for (Integer number : lastWinningNumber) {
            if (ticket.contains(number)) {
                matchedNumberCount++;
            }
        }
        return matchedNumberCount;
    }

    public void makeLottoTickets(int ticketCount) {
        while (lottoTickets.size() < ticketCount) {
            lottoTickets.add(LottoTicketFactory.getLottoTicket());
        }
    }
}
