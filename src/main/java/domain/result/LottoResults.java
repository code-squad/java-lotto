package domain.result;

import utils.LottoMachine;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResults = new ArrayList<>();

    public void addResult(LottoResult lottoResult) {
        lottoResults.add(lottoResult);
    }

    public int calcLottoProfit(int amount) {
        int purchaseMoney = LottoMachine.calcTotalPurchaseMoney(amount);
        long prizeMoney = 0;
        for (LottoResult result : lottoResults) {
            prizeMoney += result.getPrizeMoney();
        }
        return (int) (prizeMoney / purchaseMoney * 100);
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
