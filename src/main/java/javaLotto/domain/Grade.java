package javaLotto.domain;

import javaLotto.GameResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grade {
    public static GameResult checkGrade(Lotto lottos, WinningNumber winningNumber) {
        return winningNumber.checkGrade2(lottos);
    }

    public static int returnGrade(List<Integer> lotto, int grade) {
        int count = 0;
        for (int number : lotto) {
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

    private static List<Integer> getTotalPrice(List<Integer> result) {
        List<Integer> totalPrice = new ArrayList<>();
        Map<Integer, Match> returnPrice = new HashMap<>();
        returnPrice.put(3, new match3());
        returnPrice.put(4, new match4());
        returnPrice.put(5, new match5());
        returnPrice.put(6, new match6());

        for (int number : result) {
           if(number>=3) totalPrice.add(returnPrice.get(number).addPrice());
        }
        return totalPrice;
    }

    private static double changePercent(int inputPrice, int percent) {
        return ((double) percent / (double) inputPrice) * 100;
    }
}
