package saru;

import java.util.*;

public class Result {
    private Map<Rank, Integer> hitNums = new HashMap<>();
    private int buyNum;

    private Result(int buyNum) {
        this.buyNum = buyNum;
        initHitNums();
    }

    private void initHitNums() {
        hitNums.put(Rank.FIRST, 0);
        hitNums.put(Rank.SECOND, 0);
        hitNums.put(Rank.THIRD, 0);
        hitNums.put(Rank.FOURTH, 0);
        hitNums.put(Rank.FIFTH, 0);
    }

    public static Result of(int buyNum) {
        return new Result(buyNum);
    }

    // true 를 넘겨야 보너스번호에 해당
    public void increaseHit(int match, boolean isBonus) {
        Rank rank = Rank.valueOf(match, isBonus);
        if (rank == null) {
            return;
        }

        int originalValue = hitNums.get(rank);
        hitNums.put(rank, originalValue + 1);
    }

    public int getRankHitNum(Rank rank) {
        return hitNums.get(rank);
    }

    public int getMatchNum_first() {
        return getRankHitNum(Rank.FIRST);
    }

    public int getMatchNum_second() {
        return getRankHitNum(Rank.SECOND);
    }

    public int getMatchNum_third() {
        return getRankHitNum(Rank.THIRD);
    }

    public int getMatchNum_fourth() {
        return getRankHitNum(Rank.FOURTH);
    }

    public int getMatchNum_fifth() {
        return getRankHitNum(Rank.FIFTH);
    }

    public int getCalcIncome() {
        int totalIncome = getTotalIncome();
        return 100 * (totalIncome / (buyNum * 1000));
    }

    private int getTotalIncome() {
        int totalIncome = 0;

        for (Rank rank : hitNums.keySet()) {
            int hitNum = hitNums.get(rank);
            totalIncome += (rank.getWinningMoney() * hitNum);
        }

        return totalIncome;
    }
}
