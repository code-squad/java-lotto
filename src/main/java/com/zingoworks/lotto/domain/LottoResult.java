package com.zingoworks.lotto.domain;

import java.util.*;

public class LottoResult {
    private Map<Integer, Integer> winners = new HashMap<>();

    public LottoResult(List<Lottery> lotteries, String lastWinningNumbers) {
        generateWinners(lotteries, convertToProperForm(lastWinningNumbers));
    }

    public Map<Integer, Integer> getWinners() {
        return winners;
    }

    public int getEarningRate(int purchaseAmount) {
        int earningRate = (getEarning() - purchaseAmount) / purchaseAmount * 100;
        if (earningRate < 0) {
            return 0;
        }
        return earningRate;
    }

    public int getEarning() {
        int earn = 0;
        earn += winners.get(3) * 5000;
        earn += winners.get(4) * 50000;
        earn += winners.get(5) * 1500000;
        earn += winners.get(6) * 2000000000;
        return earn;
    }

    void generateWinners(List<Lottery> allLotteries, List<Integer> lastWinningNumbers) {
        winners.put(3, 0);
        winners.put(4, 0);
        winners.put(5, 0);
        winners.put(6, 0);

        for (Integer integer : getAllResults(allLotteries, lastWinningNumbers)) {
            for (int i = 3; i <= 6; i++) {
                if (integer == i) {
                    winners.put(i, winners.get(i) + 1);
                }
            }
        }
    }

    private List<Integer> getAllResults(List<Lottery> allLotteries, List<Integer> lastWinningNumbers) {
        List<Integer> allResults = new ArrayList<>();
        for (int i = 0; i < allLotteries.size(); i++) {
            allResults.add(allLotteries.get(i).countMatchingNumbers(lastWinningNumbers));
        }
        return allResults;
    }

    private List<Integer> convertToProperForm(String numbers) {
        String[] str = numbers.split(",");
        List<Integer> lastWinningNumbers = new ArrayList<>();
        for (String s : str) {
            lastWinningNumbers.add(Integer.parseInt(s));
        }
        return lastWinningNumbers;
    }
}
