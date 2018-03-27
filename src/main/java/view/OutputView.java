package view;

import domain.LottoBundle;
import dto.LottoResult;

public class OutputView {

    public static void printPurchaseHistory(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getPurchaseHistory());
    }

    public static void printResult(LottoResult result) {

    }

    private static String buildTitle() {
        return "당첨 통계\n" + "---------\n";
    }
}