package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Result {
    private final int ticketsBought;
    private Map<Match, Integer> counts;

    Result(List<Ticket> tickets, WinningLotto winningLotto) {
        this.ticketsBought = tickets.size();
        this.counts = mapCounts(getMatches(tickets, winningLotto));
    }

    private static List<Match> getMatches(List<Ticket> tickets, WinningLotto winningLotto) {
        List<Match> matches = new ArrayList<>();
        for (Ticket ticket : tickets) {
            Match match = compareTicket(ticket, winningLotto);
            if (match != null) {
                matches.add(match);
            }
        }
        return matches;
    }

    static Match compareTicket(Ticket ticket, WinningLotto winningLotto) {
        return winningLotto.createMatch(ticket);
    }

    private static Map<Match, Integer> mapCounts(List<Match> matches) {
        Map<Match, Integer> result = new HashMap<>();
        for (Match match : Match.values()) {
            result.put(match, getMatchCount(matches, match));
        }
        return result;
    }

    private static int getMatchCount(List<Match> matches, Match match) {
        return (int) matches.stream().filter(m -> m == match).count();
    }

    public int getCount(Match match) {
        return counts.get(match);
    }

    public double calculateProfit() {
        double earnings = 0;
        for (Map.Entry<Match, Integer> entry : counts.entrySet()) {
            earnings += entry.getKey().getPrize() * entry.getValue();
        }
        return (earnings / (ticketsBought * LOTTO_PRICE)) * 100;
    }
}