package lotto.lotto.view;

import lotto.lotto.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class View {

    public static void lottoAutomaticView(List<Lotto> lottos, int manualNumber) {
        System.out.println();
        System.out.printf("수동으로 %d장 자동으로 %d장 구매했습니다.\n", manualNumber, lottos.size() - manualNumber);
        for (Lotto lotto : lottos) {
            printOneLotto(lotto.getLotto());
        }
        System.out.println();
    }

    public static void printOneLotto(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i));
            if (i != lotto.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void resultLottoView(Map<Rank, Integer> result) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        for (Rank rankNum : Rank.values()) {
            System.out.print(rankNum.getCountOfMatch() + "개 일치 ");
            if (rankNum == Rank.SECOND) {
                System.out.print(", 보너스 볼  일치");
            }
            System.out.print("(" + rankNum.getTotalWinnerPrize(1) + "원)");
            System.out.println("-" + result.get(rankNum) + "개");
        }
    }

    public static void incomeMoney(ResultDTO result) {
        System.out.println("총 수익률은 " + result.getMoney() + "%입니다.");
    }
}
