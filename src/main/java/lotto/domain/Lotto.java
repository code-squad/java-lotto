package lotto.domain;

import lotto.domain.generation.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final int numberOfTickets;
    private List<Ticket> tickets;

    public Lotto(List<Ticket> auto, List<Ticket> manual) {
        this.tickets = concatenate(auto, manual);
        this.numberOfTickets = tickets.size();
    }

    private static List<Ticket> concatenate(List<Ticket> auto, List<Ticket> manual) {
        manual.addAll(auto);
        return manual;
    }

    public List<String> showPurchase() {
        List<String> receipt = new ArrayList<>();
        for (Ticket ticket : tickets) {
            receipt.add(ticket.toString());
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

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Integer> getNumbers(int index) {
        return tickets.get(index).getNumbers();
    }
}