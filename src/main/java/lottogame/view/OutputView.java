package lottogame.view;

import lottogame.domain.PrizeRank;
import lottogame.dto.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public static final int HUNDRED = 100;

    public static void printResult(int inputMoney, Result result) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------");
        List<PrizeRank> prizeRanks = new ArrayList<>(Arrays.asList(PrizeRank.values()));
        prizeRanks.remove(PrizeRank.BOOM);

        for (PrizeRank prizeRank : prizeRanks) {
            int hitCount = result.get(prizeRank);
            System.out.println(prizeRank.getMessage() + "-" + hitCount + "개");
        }

        System.out.println("총 수익률은 " + result.totalReward() / inputMoney * HUNDRED + "% 입니다.");
    }
}
