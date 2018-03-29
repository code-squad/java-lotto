package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Number;

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
        System.out.println("당첨통계");
        System.out.println("----------");
        String[] result = lotto.determineResult(winningNumbers);
        System.out.println("3개 일치 (5000원)- " + result[0] + "개");
        System.out.println("4개 일치 (50000원)- " + result[1] + "개");
        System.out.println("5개 일치 (15000000원)- " + result[2] + "개");
        System.out.println("6개 일치 (20000000000원)- " + result[3] + "개");

    }
}