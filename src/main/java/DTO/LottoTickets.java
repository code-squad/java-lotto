package DTO;

import domain.lotto.LottoTicket;
import enums.WinningRules;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    List<LottoTicket> tickets;

    public LottoTickets() {
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<WinningRules> findMatching(LottoTicket winningTicket) {
        List<WinningRules> machingRules = new ArrayList<>();

        for (LottoTicket ticket : tickets) {
            WinningRules matchedRule = getMatchedRule(winningTicket, ticket);

            if (isAddAble(matchedRule))
                machingRules.add(matchedRule);
        }

        return machingRules;
    }

    private boolean isAddAble(WinningRules matchedRule) {
        return matchedRule.getMatchCount() > WinningResult.WINNING_RESTRICTION_NUMBER;
    }

    private WinningRules getMatchedRule(LottoTicket winningTicket, LottoTicket ticket) {
        return ticket.winningMaching(winningTicket.getNumbers());
    }

    public LottoTickets createLottoTickets(Integer amount) {
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tickets.add(new LottoTicket(new LottoNumbers().createAutoNumbers()));
        }

        this.tickets = tickets;

        return this;
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
