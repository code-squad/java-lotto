package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class LottoGame {

    private List<LottoTicket> tickets;

    public LottoGame() {
        tickets = new ArrayList<>();
    }

    private int getAvailableBuyingCount(int money) {
        return money / LottoTicket.TICKET_PRICE;
    }

    /**
     * 로또 구매
     * @param money 구매금액
     * @return 구매한 로또 개수
     */
    public int buyTicket(int money) {
        int count = getAvailableBuyingCount(money);
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoTicket());
        }
        return count;
    }

    /**
     * 당첨 결과 확인
     * @param winningNumber 당첨번호
     * @return 당첨결과
     */
    public LottoResult getPrizeResult(WinningNumber winningNumber) {
        return new LottoResult(tickets.size(), tickets.stream()
                .map(ticket -> ticket.checkWinning(winningNumber))
                .collect(Collectors.toList()));
    }

    public String getTicketsString() {
        return String.join("\n",
                tickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.toList()));
    }
}
