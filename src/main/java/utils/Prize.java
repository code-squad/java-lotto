package utils;

import dto.LottoResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Prize {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private int matchPoint;
    private int prize;
    private boolean isBonusMatch;

    Prize(int matchPoint, int prize, boolean isBonusMatch) {
        this.matchPoint = matchPoint;
        this.prize = prize;
        this.isBonusMatch = isBonusMatch;
    }

    public static List<Integer> count(LottoResult results) {
        List<Prize> prizes = Arrays.asList(Prize.values());
        List<Integer> prizeCounts = new ArrayList<>();
        for (Prize prize : prizes) {
            prizeCounts.add(results.calcPrizeMatchNum(prize.matchPoint, prize.isBonusMatch));
        }
        return prizeCounts;
    }

    public static String buildPrizeCountMessage(int prizeIdx, int prizeCount) {
        List<Prize> prizes = Arrays.asList(Prize.values());
        Prize currentPrize = prizes.get(prizeIdx);
        return currentPrize.matchPoint + "개 일치 (" + currentPrize.prize + "원) - " + prizeCount + "개\n";
    }

}

