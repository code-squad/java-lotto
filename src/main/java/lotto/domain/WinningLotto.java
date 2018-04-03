package lotto.domain;

import java.util.List;

public class WinningLotto {
    static final int FIRST = 0;
    static final int LAST = 6;
    private final Ticket winningTicket;
    private final Number bonusNumber;

    public WinningLotto(Ticket winningNumbers, Number bonusNumber) {
        this.winningTicket = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static void checkDuplicate(List<Number> winningNumbers, Number bonusNumber) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    Match createMatch(Ticket ticket) {
        return Match.ofMatch(countMatchInTicket(ticket), bonusMatch(ticket));
    }

    private int countMatchInTicket(Ticket ticket) {
        return winningTicket.countMatches(ticket);
    }

    private boolean bonusMatch(Ticket ticket) {
        return ticket.contains(bonusNumber);
    }
}
