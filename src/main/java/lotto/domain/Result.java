package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.view.UserPrompt.LOTTO_PRICE;

public class Result {
    private final Lotto lotto;
    private final WinningLotto winningLotto;
    private Map<Match, Integer> result;

    public Result(Lotto lotto, WinningLotto winningLotto) {
        this.lotto = lotto;
        this.winningLotto = winningLotto;
        this.result = mapResult();
    }

    private List<Match> getMatches() {
        return lotto.createMatch(winningLotto);
    }

    private Map<Match, Integer> mapResult() {
        Map<Match, Integer> result = new HashMap<>();
        List<Match> matches = getMatches();

        for (Match nthPlace : Match.values()) {
            result.put(nthPlace, countMatches(matches, nthPlace));
        }
        return result;
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
            earnings += entry.getKey().getPrize() * entry.getValue();
        }
        return (earnings / (lotto.getSize() * LOTTO_PRICE)) * 100;
    }
}