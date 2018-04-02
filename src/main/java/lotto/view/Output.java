package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Match;
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
        System.out.println("3개 일치 (" + Match.FIFTH.getPrize() + ") - " + result.getCount(Match.FIFTH) + "개");
        System.out.println("4개 일치 (" + Match.FOURTH.getPrize() + ") - " + result.getCount(Match.FOURTH) + "개");
        System.out.println("5개 일치 (" + Match.THIRD.getPrize() + ") - " + result.getCount(Match.THIRD) + "개");
        System.out.println("5개 일치 + 보너스 볼 일치 (" + Match.SECOND.getPrize() + ") - " + result.getCount(Match.SECOND) + "개");
        System.out.println("6개 일치 (" + Match.FIRST.getPrize() + ") - " + result.getCount(Match.FIRST) + "개");
        System.out.printf("총 수익률은 %.1f%% 입니다.", result.calculateProfit());
    }
}