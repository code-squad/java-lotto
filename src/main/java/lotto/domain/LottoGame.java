package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {
    private LottoGame() { }

    public static List<LottoTicket> buyTicket(int pay) {
        return LottoTicketIssuer.issue(pay);
    }

    public static List<PrizeDivision> getResult(LottoTicket winningTicket, List<LottoTicket> tickets) {
        return tickets.stream()
                .map(ticket -> PrizeDivision.findByMatchedNumbers(ticket.match(winningTicket)))
                .collect(Collectors.toList());
    }

    public static Map<PrizeDivision, Integer> analyzeResult(List<PrizeDivision> winningResults) {
        Map<PrizeDivision, Integer> result = new EnumMap<>(PrizeDivision.class);
        Arrays.stream(PrizeDivision.values()).forEach(division -> 
                result.put(division, count(winningResults, division))
        );

        return result;
    }

    private static int count(List<PrizeDivision> winningResult, PrizeDivision division) {
        return (int) winningResult.stream()
                .filter(winning -> winning.matchNumberEqualsOf(division.getMatchedNumber()))
                .count();
    }
}

