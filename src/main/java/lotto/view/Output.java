package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Number;
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
        int first = result.countFirstPlace();
        int second = result.countSecondPlace();
        int third = result.countThirdPlace();
        int fourth = result.countFourthPlace();
        double profit = result.calculateProfit(first, second, third, fourth);

        System.out.println("당첨통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + fourth + "개");
        System.out.println("4개 일치 (50000원)- " + third + "개");
        System.out.println("5개 일치 (15000000원)- " + second + "개");
        System.out.println("6개 일치 (20000000000원)- " + first + "개");
        System.out.printf("총 수익률은 %.1f 입니다.", profit);
    }
}