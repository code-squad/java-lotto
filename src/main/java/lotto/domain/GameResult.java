package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    private final LottoTickets tickets;
    private final WinningTicket winningTicket;

    public GameResult(LottoTickets tickets, WinningTicket winningTicket) {
        this.tickets = tickets;
        this.winningTicket = winningTicket;
    }

    public List<PrizeDivision> getResult() {
        return tickets.getAllTickets().stream()
                .map(ticket -> PrizeDivision.valueOf(
                        ticket.match(winningTicket.getLottoTicket()), 
                        ticket.contains(winningTicket.getBonusNumber())))
                .collect(Collectors.toList());
    }

    public Map<PrizeDivision, Integer> getAnalyzeResult() {
        List<PrizeDivision> winningResults = getResult();
        Map<PrizeDivision, Integer> result = new EnumMap<>(PrizeDivision.class);
        Arrays.stream(PrizeDivision.values()).forEach(division ->
                result.put(division, count(winningResults, division))
        );

        return result;
    }

    public float getRateOfReturn() {
        int investment = LottoTicketIssuer.getTicketPrice() * tickets.getSize();
        int profit = getResult().stream().mapToInt(PrizeDivision::getPrize).sum();
        return (profit / (float) investment) * 100;
    }
    
    private static int count(List<PrizeDivision> winningResult, PrizeDivision division) {
        return (int) winningResult.stream()
                .filter(winning -> winning.compareBy(
                        division.getMatchedNumber(), 
                        division.isMatchedBonusNumber()))
                .count();
    }
}
