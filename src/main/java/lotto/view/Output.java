package lotto.view;

import lotto.domain.*;

public class Output {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void showPurchase(Lotto lotto) {
        for (String receipt : lotto.showPurchase()) {
            printMessage(receipt);
        }
    }

    public static void getResult(Lotto lotto, WinningLotto winningLotto) {
        Results results = new Results(lotto, winningLotto);

        System.out.println("당첨통계");
        System.out.println("----------");
        for (Match match : Match.values()) {
            System.out.println(match.toString() + results.getCount(match) + "개");
        }
        System.out.printf("총 수익률은 %.1f%% 입니다.", results.calculateProfit());
    }
}