package view;

import domain.BuyLotto;
import domain.Lotto;
import domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Output {
    public static void allLottoNum(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLotto(lotto.getLotto());
        }
        System.out.println();
    }

    private static void printLotto(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i));
            if (i != lotto.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void resultView(Map<Rank, Integer> result) {
        System.out.println("\n당첨통계");
        System.out.println("---------");
        for (Rank rankNum : Rank.values()) {
            System.out.print(rankNum.getCountOfMatch() + "개 일치 ");
            System.out.print("(" + rankNum.getWinningMoney() + "원)");
            System.out.println("-" + result.get(rankNum) + "개");
        }
    }
}
