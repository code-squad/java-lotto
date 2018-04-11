package javaLotto.domain;

import javaLotto.GameResult;

import java.util.ArrayList;
import java.util.List;


public class Grade {
    private static final int GRADE3 = 5000;
    private static final int GRADE4 = 50000;
    private static final int GRADE5 = 1500000;
    private static final int GRADE6 = 2000000000;

    public static GameResult checkGrade(Lotto lottos, WinningNumber winningNumber) {
        return winningNumber.checkGrade2(lottos);
    }

    public static int returnGrade(List<Integer> sta, int grade) {
        int count = 0;
        for (int number : sta) {
            if (number == grade) count++;
        }
        return count;
    }

    public static double returnPercent(List<Integer> result, int inputPrice) {
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

    private static double changePercent(int inputPrice, int percent) {
        return ((double)percent / (double)inputPrice) * 100;
    }
}
