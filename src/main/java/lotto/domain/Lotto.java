package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Ticket> tickets;

    public Lotto(List<Ticket> auto, List<Ticket> manual) {
        this.tickets = concatenate(auto, manual);
    }

    private static List<Ticket> concatenate(List<Ticket> auto, List<Ticket> manual) {
        auto.addAll(manual);
        return auto;
    }

    public List<String> showPurchase() {
        List<String> receipt = new ArrayList<>();
        for (Ticket ticket : tickets) {
            receipt.add(ticket.getTicketString());
        }
        return receipt;
    }

    List<Match> createMatch(WinningLotto winningLotto) {
        List<Match> matches = new ArrayList<>();
        for (Ticket ticket : tickets) {
            matches.add(winningLotto.createMatch(ticket));
        }
        return matches;
    }

    int getSize() {
        return tickets.size();
    }
}