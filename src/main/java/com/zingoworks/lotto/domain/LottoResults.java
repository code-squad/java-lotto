package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private static final int PRIZE_FIRST = 2000000000;
    private static final int PRIZE_SECOND = 1500000;
    private static final int PRIZE_THIRD = 50000;
    private static final int PRIZE_FORTH = 5000;

    private static final String COMMA = ",";

    private List<Integer> lastWinningNumbers;
    private List<Integer> results;

    public LottoResults(FullGame fullGame, String lastWinningNumbers) {
        generateLastWinningNumbers(lastWinningNumbers);
        this.results = countResults(fullGame.countFullWinning(this.lastWinningNumbers));
    }

    public List<Integer> getResults() {
        return results;
    }

    public int getEarningRate(int purchaseAmount) {
        return (earning() - purchaseAmount) / purchaseAmount * 100;
    }

    private int earning() {
        int earn = 0;
        earn += this.results.get(0) * PRIZE_FORTH;
        earn += this.results.get(1) * PRIZE_THIRD;
        earn += this.results.get(2) * PRIZE_SECOND;
        earn += this.results.get(3) * PRIZE_FIRST;
        return earn;
    }

    private void generateLastWinningNumbers(String str) {
        lastWinningNumbers = new ArrayList<>();
        String[] separatedStr = str.split(COMMA);
        for (String s : separatedStr) {
            lastWinningNumbers.add(Integer.parseInt(s));
        }
    }

    private List<Integer> countResults(List<Integer> wins) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for (Integer integer : wins) {
            if (integer == 3) {
                a++;
            }
            if (integer == 4) {
                b++;
            }
            if (integer == 5) {
                c++;
            }
            if (integer == 6) {
                d++;
            }
        }
        List<Integer> results = new ArrayList<>();
        results.add(a);
        results.add(b);
        results.add(c);
        results.add(d);

        return results;
    }
}
