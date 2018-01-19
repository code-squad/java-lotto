package dto;

import domain.lotto.LottoTicket;
import enums.WinningRules;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    List<LottoTicket> tickets;

    public LottoTickets(int amount) {
        List<LottoTicket> newTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            newTickets.add(new LottoTicket(new LottoNumbers()));
        }

        this.tickets = newTickets;
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<WinningRules> findMatching(LottoTicket winningTicket) {
        List<WinningRules> machingRules = new ArrayList<>();

        for (LottoTicket ticket : tickets) {
            WinningRules matchedRule = winningTicket.matching(ticket);
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
