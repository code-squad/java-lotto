package dto;

import domain.lotto.LottoNumber;
import domain.lotto.LottoTicket;
import enums.WinningRules;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    List<LottoTicket> tickets;

    private LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets of(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public static LottoTickets of(int amount) {
        List<LottoTicket> newTickets = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            newTickets.add(LottoTicket.of(LottoNumbers.of()));
        }

        return new LottoTickets(newTickets);
    }

    public List<WinningRules> findMatching(LottoTicket winningTicket, LottoNumber bonusNumber) {
        List<WinningRules> machingRules = new ArrayList<>();

        for (LottoTicket ticket : tickets) {
            WinningRules matchedRule = winningTicket.matching(ticket, bonusNumber);
            if (isAddAble(matchedRule))
                machingRules.add(matchedRule);
        }

        return machingRules;
    }

    private boolean isAddAble(WinningRules matchedRule) {
        return matchedRule.getMatchCount() > WinningResult.WINNING_RESTRICTION_NUMBER;
    }

    public int getSize() {
        return this.tickets.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoTicket ticket : tickets) {
            builder.append(ticket.toString());
        }
        return builder.toString();
    }
}
