package domain.result;

import utils.MoneyUtils;
import utils.OutputUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResults = new ArrayList<>();
    private List<String> resultsMessage;
    private int profit;

    public void addResult(LottoResult lottoResult) {
        lottoResults.add(lottoResult);
    }

    public long calcTotalPrizeMoney() {
        long totalPrize = 0;
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            int matchCount = calcRankNum(rank);
            totalPrize += rank.getTotalPrize(matchCount);
        }
        return totalPrize;
    }

    public int calcRankNum(Rank rank) {
        return (int) (lottoResults.stream().filter(result -> result.isSameRank(rank)).count());
    }

    public void calcProfit(int purchaseAmount) {
        profit = MoneyUtils.calcProfit(calcTotalPrizeMoney(), purchaseAmount);
    }

    public int getProfit() {
        return profit;
    }

    public void setResultMessage() {
        this.resultsMessage = OutputUtils.buildRankMessage(this);
    }

    public List<String> getResultMessage() {
        return resultsMessage;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoResult result : lottoResults) {
            builder.append(result);
        }
        return builder.toString();
    }
}
