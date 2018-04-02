package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Rank;
import lotto.domain.Result;

import java.util.List;

public class Output {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void showPurchase(Lotto lotto) {
        for (String receipt : lotto.showPurchase()) {
            printMessage(receipt);
        }
    }

    public static void showResult(Lotto lotto, List<Number> winningNumbers) {
        Result result = lotto.determineResult(winningNumbers);

        System.out.println("당첨통계");
        System.out.println("----------");
        System.out.println("3개 일치 (" + Rank.FIFTH.getPrize() + ") - " + result.getCount(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (" + Rank.FOURTH.getPrize() + ") - " + result.getCount(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (" + Rank.THIRD.getPrize() + ") - " + result.getCount(Rank.THIRD) + "개");
        System.out.println("5개 일치 + 보너스 볼 일치 (" + Rank.SECOND.getPrize() + ") - " + result.getCount(Rank.SECOND) + "개");
        System.out.println("6개 일치 (" + Rank.FIRST.getPrize() + ") - " + result.getCount(Rank.FIRST) + "개");
        System.out.printf("총 수익률은 %.1f%% 입니다.", result.calculateProfit());
    }
}