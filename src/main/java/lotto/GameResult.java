package lotto;

public class GameResult {
    private int[] matchCount;
    private double rateOfInvestment;

    public GameResult(int[] matchCount, double rateOfInvestment) {
        this.matchCount = matchCount;
        this.rateOfInvestment = rateOfInvestment;
    }

    public int getMatchCount(int position) {
        return matchCount[position];
    }

    public double getRateOfInvestment() {
        return rateOfInvestment;
    }
}
