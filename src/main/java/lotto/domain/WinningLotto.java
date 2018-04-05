package lotto.domain;

public class WinningLotto {
    static final int FIRST = 0;
    static final int LAST = 6;
    private final Ticket winningTicket;
    private final Number bonusNumber;

    public WinningLotto(Ticket winningNumbers, Number bonusNumber) {

        this.winningTicket = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void isDuplicate(Ticket winningNumbers, Number bonusNumber) throws IllegalArgumentException {
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
