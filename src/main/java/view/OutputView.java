package view;

import domain.LottoBundle;
import domain.result.LottoResults;
import domain.result.Rank;
import utils.MoneyUtils;

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
        return rank.getMatchPoint() + "개 일치 (" + rank.getPrize() + "원) - " + results.calcRankNum(rank) + "개";
    }

    private static String buildProfitContent(int amount, LottoResults results) {
        return "총 수익률은 " + MoneyUtils.calcProfit(results.calcTotalPrizeMoney(), amount) + "% 입니다.";
    }
}