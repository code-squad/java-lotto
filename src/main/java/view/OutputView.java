package view;

import domain.LottoBundle;
import domain.result.LottoResults;
import domain.result.Rank;
import utils.MoneyUtils;
import utils.OutputUtils;

import java.util.List;

public class OutputView {

    public static void printPurchaseHistory(LottoBundle lottoBundle, int totalAmount, int manualAmount) {
        System.out.println("수동으로 " + manualAmount + "장, 자동으로 "+ (totalAmount - manualAmount) + "개를 구매했습니다.");
        System.out.println(lottoBundle.getPurchaseHistory());
    }

    public static void printResult(int totalAmount, LottoResults results) {
        String resultMessage = buildTitle() + buildRankMessage(results) + buildProfitContent(totalAmount, results);
        System.out.println(resultMessage);
    }

    public static String buildRankMessage(LottoResults results) {
        List<String> resultMessages = OutputUtils.buildRankMessage(results);
        StringBuilder builder = new StringBuilder();
        for (String resultMessage : resultMessages) {
            builder.append(resultMessage);
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String buildTitle() {
        return "당첨 통계\n" + "---------\n";
    }

    private static String buildProfitContent(int amount, LottoResults results) {
        return "총 수익률은 " + MoneyUtils.calcProfit(results.calcTotalPrizeMoney(), amount) + "% 입니다.";
    }
}