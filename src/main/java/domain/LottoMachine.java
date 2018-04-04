package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoMachine {
    private List<LottoTicket> lottoTickets;
    private HashMap<Rank, Integer> result;

    public LottoMachine(int ticketCount) throws Exception {
        makeLottoTickets(ticketCount);
        initResult();
    }

    public void initResult() {
        result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public HashMap<Rank, Integer> matching(List<Integer> lastWinningNo, Integer bonusNo) throws Exception {
        WinningLotto winningLotto = LottoTicketFactory.getWinningLottoTicket(lastWinningNo, bonusNo);
        for (int index = 0; index < lottoTickets.size(); index++) {
            LottoTicket lottoTicket = lottoTickets.get(index);
            int matchedCount = lottoTicket.getMatchedNo(winningLotto);
            boolean bonus = lottoTicket.hasBonusNo(new LottoNo(bonusNo));
            updateRank(matchedCount, bonus);
        }
        return result;
    }

    public boolean updateRank(int matchedCount, boolean bonus) {
        if (matchedCount < 3) {
            return false;
        }
        if (bonus && matchedCount == 5) {
            result.put(Rank.SECOND, result.get(Rank.SECOND) + 1);
            return true;
        }
        Rank rank = Rank.getRank(matchedCount);
        result.put(rank, result.get(rank) + 1);
        return true;
    }

    public void makeLottoTickets(int ticketCount) throws Exception {
        lottoTickets = new ArrayList<>();
        while (lottoTickets.size() < ticketCount) {
            lottoTickets.add(LottoTicketFactory.getLottoTicket());
        }
    }

    public void makeLottoTickets(List<Integer> numbers) throws Exception {
        lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicketFactory.getLottoTicket(numbers));
    }
}