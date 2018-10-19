package com.zingoworks.lotto.domain;

import java.util.*;

public class LottoResult {
    public static final int PRIZE_FIRST = 2000000000;
    public static final int PRIZE_SECOND = 1500000;
    public static final int PRIZE_THIRD = 50000;
    public static final int PRIZE_FORTH = 5000;

    private Map<Integer, Integer> wins;

    public LottoResult(List<Lottery> lotteries, String lastWinningNumbers) {
        generateTotalWinningStatus(lotteries, lastWinningNumbers);
    }

    public int getNumberOfWins(int matching) {
        return wins.get(matching);
    }

    public int getEarningRate(int purchaseAmount) {
        int earningRate = (computeEarning() - purchaseAmount) / purchaseAmount * 100;
        if (earningRate < 0) {
            return 0;
        }
        return earningRate;
    }

    private int computeEarning() {
        int earn = 0;
        earn += getNumberOfWins(3) * PRIZE_FORTH;
        earn += getNumberOfWins(4) * PRIZE_THIRD;
        earn += getNumberOfWins(5) * PRIZE_SECOND;
        earn += getNumberOfWins(6) * PRIZE_FIRST;
        return earn;
    }

    private void generateTotalWinningStatus(List<Lottery> lotteries, String lastWinningNumbers) {
        List<Integer> winningNumbers = convertToListedNumbers(lastWinningNumbers);

        wins = new HashMap<>();
        wins.put(3, 0);
        wins.put(4, 0);
        wins.put(5, 0);
        wins.put(6, 0);

        for (Integer integer : getCounts(lotteries, winningNumbers)) {
            increaseTotalNumberOfWins(integer);
        }
    }

    private List<Integer> getCounts(List<Lottery> lotteries, List<Integer> lastWinningNumbers) {
        List<Integer> counts = new ArrayList<>();
        for (Lottery lottery : lotteries) {
            counts.add(lottery.countMatchingNumbers(lastWinningNumbers));
        }
        return counts;
    }

    private void increaseTotalNumberOfWins(Integer integer) {
        for (int i = 3; i <= 6; i++) {
            increaseNumberOfWins(integer, i);
        }
    }

    private void increaseNumberOfWins(Integer integer, int i) {
        if (integer == i) {
            wins.put(i, wins.get(i) + 1);
        }
    }

    private List<Integer> convertToListedNumbers(String numbers) {
        String[] separatedNumbers = numbers.split(",");
        List<Integer> listedNumbers = new ArrayList<>();
        for (String s : separatedNumbers) {
            listedNumbers.add(Integer.parseInt(s));
        }
        return listedNumbers;
    }
}
