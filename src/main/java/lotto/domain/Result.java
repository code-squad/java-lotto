package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.view.UserPrompt.LOTTO_PRICE;

public class Result {
    private final int ticketsBought;
    private Map<Match, Integer> result;

    public Result(Lotto lotto, WinningLotto winningLotto) {
        this.ticketsBought = lotto.getSize();
        this.result = mapResult(lotto, winningLotto);
    }

    private Map<Match, Integer> mapResult(Lotto lotto, WinningLotto winningLotto) {
        Map<Match, Integer> result = new HashMap<>();
        List<Match> matches = getMatches(lotto, winningLotto);

        for (Match nthPlace : Match.values()) {
            result.put(nthPlace, countMatches(matches, nthPlace));
        }
        return result;
    }

    private List<Match> getMatches(Lotto lotto, WinningLotto winningLotto) {
        return lotto.createMatch(winningLotto);
    }

    static int countMatches(List<Match> matches, Match nthPlace) {
        return (int) matches.stream().filter(m -> m == nthPlace).count();
    }

    public int getCount(Match match) {
        return result.get(match);
    }

    public double calculateProfit() { 
        double earnings = 0;
        for (Map.Entry<Match, Integer> entry : result.entrySet()) {
            earnings += entry.getKey().calculatePrize(entry.getValue());
        }
        return (earnings / (ticketsBought * LOTTO_PRICE)) * 100;
    }
}