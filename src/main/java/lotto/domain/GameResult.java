package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    private final List<LottoTicket> tickets;
    private final LottoTicket winningTicket;

    public GameResult(List<LottoTicket> tickets, LottoTicket winningTicket) {
        this.tickets = tickets;
        this.winningTicket = winningTicket;
    }

    public List<PrizeDivision> getResult() {
        return tickets.stream()
                .map(ticket -> PrizeDivision.findByMatchedNumbers(ticket.match(winningTicket)))
                .collect(Collectors.toList());
    }

    public Map<PrizeDivision, Integer> analyzeResult() {
        List<PrizeDivision> winningResults = getResult();
        Map<PrizeDivision, Integer> result = new EnumMap<>(PrizeDivision.class);
        Arrays.stream(PrizeDivision.values()).forEach(division ->
                result.put(division, count(winningResults, division))
        );

        return result;
    }

    public float getRateOfReturn() {
        int investment = LottoTicketIssuer.getTicketPrice() * tickets.size();
        int profit = getResult().stream().mapToInt(PrizeDivision::getPrize).sum();
        
        return (profit * 100) / (float) investment;
    }
    
    private static int count(List<PrizeDivision> winningResult, PrizeDivision division) {
        return (int) winningResult.stream()
                .filter(winning -> winning.matchNumberEqualsOf(division.getMatchedNumber()))
                .count();
    }
}
