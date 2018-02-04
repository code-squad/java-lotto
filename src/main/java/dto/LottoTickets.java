package dto;

import domain.lotto.LottoNumber;
import domain.lotto.LottoTicket;
import enums.WinningRules;
import input.Input;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    List<LottoTicket> autoTickets;
    List<LottoTicket> manualTickets;

    private LottoTickets(List<LottoTicket> autoTickets, List<LottoTicket> manualTickets) {
        this.autoTickets = autoTickets;
        this.manualTickets = manualTickets;
    }

    public static LottoTickets of(List<LottoTicket> newAutoTickets, List<LottoTicket> newManualTickets) {
        return new LottoTickets(newAutoTickets, newManualTickets);
    }

    public static LottoTickets of(int amount, int manualBuyNumber) {
        List<LottoTicket> newAutoTickets = new ArrayList<>();
        List<LottoTicket> newManualTickets = new ArrayList<>();

        Input.of().printManualNumberMessage();

        for (int i = 0; i < manualBuyNumber; i++) {//수동
            newManualTickets.add(LottoTicket.of(Input.of().inputManualNumber()));
        }

        for (int i = 0; i < amount - manualBuyNumber; i++) {//자동
            newAutoTickets.add(LottoTicket.of(LottoNumbers.of()));
        }

        return new LottoTickets(newAutoTickets, newManualTickets);
    }

    public List<WinningRules> findMatching(LottoTicket winningTicket, LottoNumber bonusNumber) {
        List<WinningRules> machingRules = new ArrayList<>();

        for (LottoTicket ticket : mergeTickets()) {
            WinningRules matchedRule = winningTicket.matching(ticket, bonusNumber);
            if (isAddAble(matchedRule))
                machingRules.add(matchedRule);
        }

        return machingRules;
    }

    private List<LottoTicket> mergeTickets() {
        List<LottoTicket> mergeTickets = new ArrayList<>();
        mergeTickets.addAll(this.manualTickets);
        mergeTickets.addAll(this.autoTickets);

        return mergeTickets;
    }

    private boolean isAddAble(WinningRules matchedRule) {
        return matchedRule.getMatchCount() > WinningResult.WINNING_RESTRICTION_NUMBER;
    }

    public int getManualSize() {
        return this.manualTickets.size();
    }

    public int getAutoSize() {
        return this.autoTickets.size();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoTicket ticket : mergeTickets()) {
            builder.append(ticket.toString());
        }
        return builder.toString();
    }
}
