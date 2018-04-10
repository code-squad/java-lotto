package javaLotto.domain;

import java.util.ArrayList;
import java.util.List;


public class Grade {
    private static final int GRADE3 = 5000;
    private static final int GRADE4 = 50000;
    private static final int GRADE5 = 1500000;
    private static final int GRADE6 = 2000000000;

    public static List<Integer> checkGrade(Lotto lottos, WinningNumber winngNumber) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> lotto : lottos.getLottos()) {
             result.add(checkMatchCount(winngNumber, lotto));
        }
        return result;
    }

    private static int checkMatchCount(WinningNumber winngNumber, List<Integer> lotto) {
        int matchCount = 0;
        for (int number : winngNumber.getWinningNumber()) {
            if (lotto.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static int returnGrade(List<Integer> sta, int grade) {
        int count = 0;
        for (int number : sta) {
            if (number == grade) count++;
        }
        return count;
    }


    public static int returnPercent(List<Integer> result, int inputPrice) {
        int percent = 0;
        for (int price : getTotalPrice(result)) {
            percent += price;
        }
        return changePercent(inputPrice, percent);
    }

    private static List<Integer> getTotalPrice(List<Integer> sta) {
        List<Integer> totalPrice = new ArrayList<>();
        for (int number : sta) {
            //  if문 삭제
            if (number == 3) totalPrice.add(GRADE3);
            if (number == 4) totalPrice.add(GRADE4);
            if (number == 5) totalPrice.add(GRADE5);
            if (number == 6) totalPrice.add(GRADE6);
        }
        return totalPrice;
    }

    private static int changePercent(int inputPrice, int percent) {
        return percent / inputPrice * 100;
    }
}
