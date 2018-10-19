package com.zingoworks.lotto.domain;

import java.util.*;

public class LottoResult {
    public static final int PRIZE_FIRST = 2000000000;
    public static final int PRIZE_SECOND = 1500000;
    public static final int PRIZE_THIRD = 50000;
    public static final int PRIZE_FORTH = 5000;

    private Map<Score, Integer> totalWinningStatus;

    public LottoResult(List<Lottery> lotteries, WinningLottery winningLottery) {
        generateTotalWinningStatus(lotteries, winningLottery);
    }

    public int getNumberOfWins(int countOfWins) {
        return totalWinningStatus.get(new Score(countOfWins, false));
    }

//    public int getEarningRate(int purchaseAmount) {
//        int earningRate = (computeEarning() - purchaseAmount) / purchaseAmount * 100;
//        if (earningRate < 0) {
//            return 0;
//        }
//        return earningRate;
//    }
//
//    private int computeEarning() {
//        int earn = 0;
//        earn += getNumberOfWins(3) * PRIZE_FORTH;
//        earn += getNumberOfWins(4) * PRIZE_THIRD;
//        earn += getNumberOfWins(5) * PRIZE_SECOND;
//        earn += getNumberOfWins(6) * PRIZE_FIRST;
//        return earn;
//    }

    private void generateTotalWinningStatus(List<Lottery> lotteries, WinningLottery winningLottery) {
        totalWinningStatus = new HashMap<>();
        totalWinningStatus.put(new Score(3,false), 0);
        totalWinningStatus.put(new Score(4,false), 0);
        totalWinningStatus.put(new Score(5,false), 0);
        totalWinningStatus.put(new Score(5,true), 0);
        totalWinningStatus.put(new Score(6,false), 0);

        for (int i = 0; i < lotteries.size(); i++) {
            if(lotteries.get(i).getCountOfHit(winningLottery) == 5 && lotteries.get(i).isBonusHit(winningLottery)) {
                totalWinningStatus.put(lotteries.get(i).getScore(winningLottery), totalWinningStatus.get(lotteries.get(i).getScore(winningLottery))+ 1);
            }
        }

        for (int i = 0; i < lotteries.size(); i++) {
            for (int j = 3; j <= 6; j++) {
                if(lotteries.get(i).getCountOfHit(winningLottery) == j && !lotteries.get(i).isBonusHit(winningLottery)) {
                    totalWinningStatus.put(lotteries.get(i).getScore(winningLottery), totalWinningStatus.get(lotteries.get(i).getScore(winningLottery))+ 1);
                }
            }
        }



//        for (Integer integer : getCounts(lotteries, winningLottery)) {
//            increaseTotalNumberOfWins(integer);
//        }
    }



//    private List<Integer> getCounts(List<Lottery> lotteries, WinningLottery winningLottery) {
//        List<Integer> counts = new ArrayList<>();
//        for (Lottery lottery : lotteries) {
//            counts.add(lottery.getCountOfHit(winningLottery));
//        }
//        return counts;
//    }
//
//    private void increaseTotalNumberOfWins(Integer integer) {
//        for (int i = 3; i <= 6; i++) {
//            increaseNumberOfWins(integer, i);
//        }
//    }
//
//    private void increaseNumberOfWins(Integer integer, int i) {
//        if (integer == i) {
//            totalWinningStatus.put(i, totalWinningStatus.get(i) + 1);
//        }
//    }
}
