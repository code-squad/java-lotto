package lotto.domain;

import java.util.Map;

public class GameResult {
    private Map<Rank, Integer> matchCount;
    private double rateOfInvestment;

    public GameResult(Map<Rank, Integer> matchCount, double rateOfInvestment) {
        this.matchCount = matchCount;
        this.rateOfInvestment = rateOfInvestment;
    }

    public int getMatchCount(Rank rank) {
        return matchCount.get(rank);
    }

    public double getRateOfInvestment() {
        return rateOfInvestment;
    }
}
