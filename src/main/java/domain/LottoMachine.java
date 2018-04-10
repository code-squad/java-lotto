package domain;

import Util.Database;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private static final int paymentPerTicket = 1000;
    private List<LottoTicket> lottoTickets;
    Map<Rank, Integer> ranking;

    public LottoMachine() {
        init();
    }

    public static int getTotalCount(int payment) {
        int totalTicketCount = payment / paymentPerTicket;
        if (totalTicketCount < 1) {
            throw new IllegalArgumentException("지불금액이 적습니다. 1장당 1천원.");
        }
        return totalTicketCount;
    }

    public static int getAutoCount(int totalCount, int manualCount) {
        int autoCount = totalCount - manualCount;
        if (autoCount < 0) {
            throw new IllegalArgumentException("수동 구입 매수는 전체 매수보다 클 수 없습니다.");
        }
        return autoCount;
    }

    // 테스트 이유를 제외하면 static을 할 이유가 있는가
    public List<LottoTicket> createManualTickets(List<String> numberLines) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (String numberLine : numberLines) {
            LottoTicket lottoTicket = LottoTicket.getLottoTicket(LottoNo.getLottoNosFromString(numberLine));
            lottoTickets.add(lottoTicket);
        }
        this.lottoTickets.addAll(lottoTickets);
        return lottoTickets;
    }

    public List<LottoTicket> createAutoTickets(int autoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int index = 0; index < autoCount; index++) {
            lottoTickets.add(LottoTicket.getLottoTicket(LottoNo.getLottoNos()));
        }
        this.lottoTickets.addAll(lottoTickets);
        return lottoTickets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTickets) {
            sb.append(lottoTicket.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    private void init() {
        lottoTickets = new ArrayList<>();
        rankingInit();
    }

    private void rankingInit() {
        ranking = new HashMap<>();
        for (Rank rank : Rank.values()) {
            ranking.put(rank, 0);
        }
    }

    public Result matching(String lastWinningNo, String bonusNo, int payment) throws Exception {
//        rankingInit(); // web에서 다시하기 했을 때, 이전 데이터 누적 방지
        List<LottoNo> lottoNos = LottoNo.getLottoNosFromString(lastWinningNo);
        LottoNo lottoNo = new LottoNo(bonusNo);
        WinningLotto winningLotto = new WinningLotto(lottoNos, lottoNo);
        for (int index = 0; index < lottoTickets.size(); index++) {
            LottoTicket lottoTicket = lottoTickets.get(index);
            Rank rank = winningLotto.match(lottoTicket);
            try {
                ranking.put(rank, this.ranking.get(rank) + 1);
            } catch (Exception e) {
                // todo refactor : NullException -> RuntimeException
            }
        }



        return new Result(ranking, payment);
    }
}