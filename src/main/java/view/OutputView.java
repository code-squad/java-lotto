package view;

import domain.LottoBundle;
import domain.result.LottoResults;
import domain.result.Rank;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printPurchaseHistory(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getPurchaseHistory());
    }

    public static void printResult(int amount, LottoResults results) {
        String resultMessage = buildTitle() + buildRankMessage(results) + buildProfitContent(amount, results);
        System.out.println(resultMessage);
    }

    private static String buildTitle() {
        return "당첨 통계\n" + "---------\n";
    }

    private static String buildRankMessage(LottoResults results) {
        Rank[] ranks = Rank.values();
        StringBuilder builder = new StringBuilder();
        for (Rank rank : ranks) {
            builder.append(doBuild(rank, results));
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String doBuild(Rank rank, LottoResults results) {
        return rank.getMatchPoint() + "개 일치 (" + rank.getPrize() + ") - " + results.calcRankNum(rank) + "개";
    }

    private static String buildProfitContent(int amount, LottoResults results) {
        int profit = results.calcLottoProfit(amount);
        return "총 수익률은 " + profit + "% 입니다.";
    }
}