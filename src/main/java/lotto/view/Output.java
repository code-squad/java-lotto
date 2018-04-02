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
        System.out.println("3개 일치 (" + Match.FIFTH.getPrize() + ") - " + result.getCount(Match.FIFTH) + "개");
        System.out.println("4개 일치 (" + Match.FOURTH.getPrize() + ") - " + result.getCount(Match.FOURTH) + "개");
        System.out.println("5개 일치 (" + Match.THIRD.getPrize() + ") - " + result.getCount(Match.THIRD) + "개");
        System.out.println("5개 일치 + 보너스 볼 일치 (" + Match.SECOND.getPrize() + ") - " + result.getCount(Match.SECOND) + "개");
        System.out.println("6개 일치 (" + Match.FIRST.getPrize() + ") - " + result.getCount(Match.FIRST) + "개");
        System.out.printf("총 수익률은 %.1f%% 입니다.", result.calculateProfit());
    }
}