package domain.result;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResults = new ArrayList<>();

    public void addResult(LottoResult lottoResult) {
        lottoResults.add(lottoResult);
    }

    public long calcTotalPrizeMoney() {
        long money = 0;
        for (LottoResult result : lottoResults) {
            money += result.getPrizeMoney();
        }
        return money;
    }

    public int calcRankNum(Rank rank) {
        return (int) (lottoResults.stream().filter(result -> result.isSameRank(rank)).count());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LottoResults{");
        for (LottoResult result : lottoResults) {
            builder.append(result.toString());
            builder.append("}\n");
        }
        return builder.toString();
    }
}
