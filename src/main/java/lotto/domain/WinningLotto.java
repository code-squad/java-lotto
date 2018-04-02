package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    static final int FIRST = 0;
    static final int LAST = 6;
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
        List<Number> winningTicket = new ArrayList<>();
        if (!winningNumbers.contains(bonusNumber)) {
            winningTicket.add(bonusNumber);
            return winningTicket;
        }
        throw new IllegalArgumentException();
    }

    Match createMatch(Ticket ticket) {
        return Match.ofMatch(countMatchInTicket(ticket), bonusMatch(ticket));
    }

    private int countMatchInTicket(Ticket ticket) {
        return (int) winningTicket.stream().filter(ticket::contains).count();
    }

    private boolean bonusMatch(Ticket ticket) {
        return ticket.contains(bonusNumber);
    }
}
