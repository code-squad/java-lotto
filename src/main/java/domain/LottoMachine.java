package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<LottoTicket> lottoTickets;
    private LottoResult lottoResult;

    public LottoMachine(int ticketCount) throws Exception {
        makeLottoTickets(ticketCount);
        lottoResult = LottoResult.getInstance();
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public void getMatch(List<Integer> lastWinningNumber, Integer bonusNumber) throws Exception {
        LottoTicket winningLottoTicket = LottoTicketFactory.getWinningLottoTicket(lastWinningNumber);
        for (int index = 0; index < lottoTickets.size(); index++) {
            LottoTicket lottoTicket = lottoTickets.get(index);
            int matchedNumberCount = countMatchedNumber(lottoTicket, winningLottoTicket);
            lottoResult.isValidNumber(matchedNumberCount, lottoTicket.hasBonusNumber(bonusNumber));
        }
    }

    public int countMatchedNumber(LottoTicket ticket, LottoTicket winningLottoTicket) {
        return ticket.getMatchedCount(winningLottoTicket);
    }

    public void makeLottoTickets(int ticketCount) throws Exception {
        lottoTickets = new ArrayList<>();
        while (lottoTickets.size() < ticketCount) {
            lottoTickets.add(LottoTicketFactory.getLottoTicket());
        }
    }
}