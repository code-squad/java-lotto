package lotto.domain;

import lotto.domain.generation.Number;
import lotto.domain.generation.Ticket;

public class WinningLotto {
    private final Ticket winningTicket;
    private final Number bonusNumber;

    public WinningLotto(Ticket winningNumbers, Number bonusNumber) {
        isDuplicate(winningNumbers, bonusNumber);
        this.winningTicket = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    static void isDuplicate(Ticket winningNumbers, Number bonusNumber) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("입력된 번호는 당첨번호에 이미 있습니다.");
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