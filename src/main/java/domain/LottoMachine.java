package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private List<LottoTicket> lottoTickets;
    private Map<Rank, Integer> result;

    public LottoMachine(int ticketCount) {
        // pobi's advice 구현하기
        // this(makeLottoTickets(ticketCount));
        makeLottoTickets(ticketCount);
        initResult();
    }

    // for test
    public LottoMachine(List<Integer> numbers) {
        makeLottoTickets(numbers);
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

    public Map<Rank, Integer> matching(List<LottoNo> lastWinningNo, LottoNo bonusNo) {
        WinningLotto winningLotto = LottoTicketFactory.getWinningLottoTicket(lastWinningNo, bonusNo);
        for (int index = 0; index < lottoTickets.size(); index++) {
            LottoTicket lottoTicket = lottoTickets.get(index);
            int matchedCount = lottoTicket.getMatchedNo(winningLotto);
            boolean bonus = lottoTicket.hasBonusNo(bonusNo);
            isRank(matchedCount, bonus);
        }
        return result;
    }

    public boolean isRank(int matchedCount, boolean bonus) {
        if (matchedCount < 3) {
            return false;
        }
        Rank rank = Rank.valueOf(matchedCount, bonus);
        result.put(rank, result.get(rank) + 1);
        return true;
    }

    public void makeLottoTickets(int ticketCount) {
        lottoTickets = new ArrayList<>();
        while (lottoTickets.size() < ticketCount) {
            lottoTickets.add(LottoTicketFactory.getLottoTicket());
        }
    }

    public void makeLottoTickets(List<Integer> numbers) {
        lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicketFactory.getLottoTicket(numbers));
    }
}