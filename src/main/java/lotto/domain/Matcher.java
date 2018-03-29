package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matcher {

    public static Map<Ticket, Integer> compareTickets(List<Number> winningNums, List<Ticket> tickets) {
        Map<Ticket, Integer> matches = new HashMap<>();
        for (Ticket ticket : tickets) {
            matches.put(ticket, ticket.findMatch(winningNums));
        }
        return matches;
    }
}
