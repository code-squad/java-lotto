package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Number> winningTicket;
    private final Number bonusNumber;

    WinningLotto(List<Number> winningTicket, Number bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    int countMatchInTicket(Ticket ticket) {
        return (int) winningTicket.stream().filter(ticket::contains).count();
    }

    public boolean bonusMatch(Ticket ticket) {
        return ticket.contains(bonusNumber);
    }
}
