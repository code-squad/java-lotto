package lottogame.view;

import lottogame.domain.PrizeRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printResult(int inputMoney, Map<PrizeRank, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------");
        int priceMoney = 0;
        List<PrizeRank> prizeRanks = Arrays.asList(PrizeRank.values());
        prizeRanks.remove(PrizeRank.BOOM);

        for (PrizeRank prizeRank : prizeRanks) {
            int hitCount = resultMap.get(prizeRank);
            System.out.println(prizeRank.getMessage() + "-" + hitCount + "개");
            priceMoney += prizeRank.getReward() * hitCount;
        }

        System.out.println("총 수익률은 " + priceMoney / inputMoney * 100 + "% 입니다.");
    }
}
