package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Result {
    private final List<Rank> wins;
    private final int ticketsBought;
    private Map<Rank, Integer> counts;

    Result(List<Ticket> tickets, Ticket winningTicket, Number bonusNumber) {
        this.ticketsBought = tickets.size();
        this.wins = drawWins(tickets, winningTicket, bonusNumber);
        this.counts = mapCounts();
    }

    private static List<Rank> drawWins(List<Ticket> tickets, Ticket winningTicket, Number bonusNumber) {
        List<Rank> wins = new ArrayList<>();
        for (Ticket ticket : tickets) {
            Rank win = drawWin(ticket, winningTicket, bonusNumber);
            if (win != null) {
                wins.add(win);
            }
        }
        return wins;
    }

    static Rank drawWin(Ticket ticket, Ticket winningTicket, Number bonusNumber) {
        int matchCount = ticket.countMatchInTicket(winningTicket);
        boolean bonus = ticket.bonusMatch(bonusNumber);

        return Rank.ofRank(matchCount, bonus);
    }

    private Map<Rank, Integer> mapCounts() {
        Map<Rank, Integer> counts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            counts.put(rank, getWinCount(rank));
        }
        return counts;
    }

    private int getWinCount(Rank rank) {
        return (int) wins.stream().filter(wins -> wins == rank).count();
    }

    public int getCount(Rank rank) {
        return counts.get(rank);
    }

    public double calculateProfit() {
        double earnings = 0;
        for (Map.Entry<Rank, Integer> entry : counts.entrySet()) {
            earnings += entry.getKey().getPrize() * entry.getValue();
        }
        return (earnings / (ticketsBought * LOTTO_PRICE)) * 100;
    }
}