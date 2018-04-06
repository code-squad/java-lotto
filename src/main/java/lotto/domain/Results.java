package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.utils.Validator.LOTTO_PRICE;

public class Results {
    private final int ticketsBought;
    private List<Result> results;
    private final double profit;

    public Results(Lotto lotto, WinningLotto winningLotto) {
        this.ticketsBought = lotto.getNumberOfTickets();
        this.results = produceResults(lotto, winningLotto);
        this.profit = calculateProfit();
    }

    private List<Result> produceResults(Lotto lotto, WinningLotto winningLotto) {
        List<Result> results = new ArrayList<>();
        List<Match> matches = getMatches(lotto, winningLotto);

        for (Match nthPlace : Match.values()) {
            results.add(new Result(nthPlace, countMatches(matches, nthPlace)));
        }
        return results;
    }

    private List<Match> getMatches(Lotto lotto, WinningLotto winningLotto) {
        return lotto.createMatch(winningLotto);
    }

    static int countMatches(List<Match> matches, Match nthPlace) {
        return (int) matches.stream().filter(m -> m == nthPlace).count();
    }

    public int getCount(Match match) {
        for (Result result : results) {
            if (result.isOfMatch(match)) {
                return result.getCount();
            }
        }
        return 0;
    }

    public double calculateProfit() {
        double earnings = 0;
        for (Result result : results) {
            earnings += result.calculatePrize();
        }
        return (earnings / (ticketsBought * LOTTO_PRICE)) * 100;
    }

    public List<Result> getResults() {
        return results;
    }

    public double getProfit() {
        return profit;
    }
}