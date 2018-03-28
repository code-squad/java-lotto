package view;

import domain.LottoBundle;
import domain.result.LottoResults;

public class OutputView {

    public static void printPurchaseHistory(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getPurchaseHistory());
    }

    public static void printResult(LottoResults results) {
        System.out.println(buildTitle() + results.toString());
    }

    private static String buildTitle() {
        return "당첨 통계\n" + "---------\n";
    }
}