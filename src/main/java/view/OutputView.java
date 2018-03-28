package view;

import domain.LottoBundle;
import domain.result.LottoResults;
import domain.result.Rank;

public class OutputView {

    public static void printPurchaseHistory(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getPurchaseHistory());
    }
    
    public static void printResult(int amount, LottoResults results) {
        String resultMessage = buildTitle() + Rank.buildRankMessage(results) + buildProfitContent(amount, results);
        System.out.println(resultMessage);
    }

    private static String buildTitle() {
        return "당첨 통계\n" + "---------\n";
    }

    private static String buildProfitContent(int amount, LottoResults results) {
        int profit = results.calcLottoProfit(amount);
        return "총 수익률은 " + profit + "% 입니다.";
    }
}