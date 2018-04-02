package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Number> winningTicket;
    private final Number bonusNumber;

    WinningLotto(List<Number> winningTicket, Number bonusNumber) {
        checkDuplicate(winningTicket, bonusNumber);
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public static List<Number> checkDuplicate(List<Number> winningNumbers, Number bonusNumber) throws IllegalArgumentException {
        if (!winningNumbers.contains(bonusNumber)) {
            winningNumbers.add(bonusNumber);
            return winningNumbers;
        }
        throw new IllegalArgumentException();
    }

    Match createMatch(Ticket ticket) {
        return Match.ofMatch(countMatchInTicket(ticket), bonusMatch(ticket));
    }

    int countMatchInTicket(Ticket ticket) {
        return (int) winningTicket.stream().filter(ticket::contains).count();
    }

    public boolean bonusMatch(Ticket ticket) {
        return ticket.contains(bonusNumber);
    }
}
