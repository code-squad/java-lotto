package lotto.domain;

import java.util.List;

public class WinningLotto {
    private static final int FIRST = 0;
    private static final int LAST = 6;
    private final List<Number> winningTicket;
    private final Number bonusNumber;

    public WinningLotto(List<Number> winningNumbers) {
        List<Number> winningTicket = winningNumbers.subList(FIRST, LAST);
        Number bonusNumber = winningNumbers.get(LAST);

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
