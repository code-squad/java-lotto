package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private static final String COMMA = ",";
    private List<Integer> lastWinningNumbers;
    public List<Integer> results;

    public LottoResults(FullGame fullGame, String lastWinningNumbers) {
        generateLastWinningNumbers(lastWinningNumbers);
        this.results = countResults(countFullWinning(fullGame));
    }

    public int getEarningRate(int purchaseAmount) {
        return (earning() - purchaseAmount) / purchaseAmount * 100;
    }

    private int earning() {
        int earn = 0;
        earn += this.results.get(0) * 5000;
        earn += this.results.get(1) * 50000;
        earn += this.results.get(2) * 1500000;
        earn += this.results.get(3) * 2000000000;
        return earn;
    }

    private void generateLastWinningNumbers(String str) {
        lastWinningNumbers = new ArrayList<>();
        String[] separatedStr = str.split(COMMA);
        for (String s : separatedStr) {
            lastWinningNumbers.add(Integer.parseInt(s));
        }
    }

    private List<Integer> countResults(List<Integer> win) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for (Integer integer : win) {
            if(integer == 3) {
                a++;
            }
            if(integer == 4) {
                b++;
            }
            if(integer == 5) {
                c++;
            }
            if(integer == 6) {
                d++;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);

        return result;
    }

    private List<Integer> countFullWinning(FullGame fullGame) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < fullGame.getFullGame().size(); i++) {
            results.add(countWinning(fullGame.getFullGame().get(i)));
        }
        return results;
    }

    private int countWinning(Game game) {
        int count = 0;
        for (int i = 0; i < game.getGameNumber().size(); i++) {
            if(lastWinningNumbers.contains(game.getGameNumber().get(i))) {
                count++;
            }
        }
        return count;
    }
}
