package view;

import domain.LottoBundle;
import dto.LottoResult;
import utils.Prize;

import java.util.List;

public class OutputView {

    public static void printPurchaseHistory(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getPurchaseHistory());
    }

    public static void printResult(LottoResult result) {
        String resultMessage = buildTitle() + buildMatchResult(result);
        System.out.println(resultMessage);
    }

    private static String buildTitle() {
        return "당첨 통계\n" + "---------\n";
    }

    private static String buildMatchResult(LottoResult result) {
        List<Integer> prizeCounts = Prize.count(result);
        StringBuilder builder = new StringBuilder();
        for (int prizeIdx = 0; prizeIdx < prizeCounts.size(); prizeIdx++) {
            builder.append(Prize.buildPrizeCountMessage(prizeIdx, prizeCounts.get(prizeIdx)));
        }
        return builder.toString();
    }
}