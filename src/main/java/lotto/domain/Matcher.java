package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Matcher {

    public static List<Integer> compareTickets(List<Number> winningNums, List<Ticket> tickets) {
        List<Integer> matches = new ArrayList<>();
        for (Ticket ticket : tickets) {
            matches.add(ticket.countMatch(winningNums));
        }
        return matches;
    }
}