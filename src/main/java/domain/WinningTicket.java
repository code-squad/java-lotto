package domain;

import enums.Rank;

import java.util.List;

/**
 * Created by hoon on 2018. 1. 26..
 */
public class WinningTicket {
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningTicket(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Ticket ticket) {
        Integer matchedCount = (int)winningNumbers.stream().filter(ticket::contains).count();
        if(matchedCount == 5 && isBonusNumberMatched(ticket)) {
            return Rank.SECOND;
        }
        return Rank.valueOf(matchedCount);
    }

    private Boolean isBonusNumberMatched(Ticket ticket) {
        return ticket.contains(bonusNumber);
    }

}
