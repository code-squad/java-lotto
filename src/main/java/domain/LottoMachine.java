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
        this(makeLottoTickets(ticketCount));
    }

    public LottoMachine(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
        initResult();
    }

    public static List<LottoTicket> makeLottoTickets(int ticketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        while (lottoTickets.size() < ticketCount) {
            lottoTickets.add(LottoTicket.getLottoTicket(LottoNo.getLottoNos()));
        }
        return lottoTickets;
    }

    public void initResult() {
        result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public Map<Rank, Integer> matching(List<LottoNo> lastWinningNo, LottoNo bonusNo) {
        WinningLotto winningLotto = new WinningLotto(lastWinningNo, bonusNo);
        for (int index = 0; index < lottoTickets.size(); index++) {
            LottoTicket lottoTicket = lottoTickets.get(index);
            Rank rank = winningLotto.match(lottoTicket);
            try {
                result.put(rank, result.get(rank) + 1);
            } catch (Exception e) {
                continue;
            }
        }
        return result;
    }
}