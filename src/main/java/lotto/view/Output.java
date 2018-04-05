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
        Result result = new Result(lotto, winningLotto);

        System.out.println("당첨통계");
        System.out.println("----------");
        for (Match match : Match.values()) {
            if (match.isSecond()) {
                System.out.println(match.getMatchCount() + "개 일치 + 보너스 볼 일치 (" + match.getPrize() + ") - " + result.getCount(match) + "개");
            }
            System.out.println(match.getMatchCount() + "개 일치 (" + match.getPrize() + ") - " + result.getCount(match) + "개");
        }
        System.out.printf("총 수익률은 %.1f%% 입니다.", result.calculateProfit());
    }
}