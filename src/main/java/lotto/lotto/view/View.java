package lotto.lotto.view;

import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class View {

    public static void lottoAutomaticView(List<Lotto> lottos) {
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

    public static void resultLottoView(HashMap<Rank, Integer> result) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        for (Rank rankNum : Rank.values()) {
            System.out.print(rankNum.getCountOfMatch() + "개 일치 ");
            if (rankNum == Rank.SECOND) {
                System.out.print(", 보너스 볼  일치");
            }
            System.out.print("(" + rankNum.getWinningMoney() + "원)");
            System.out.println("-" + result.get(rankNum) + "개");
        }
    }

    public static void incomeMoney(HashMap<Rank, Integer> result, int money) {
        int incomeMoney = 0;
        for (Rank rankNum : Rank.values()) {
            incomeMoney += (rankNum.getWinningMoney() * result.get(rankNum));
        }
        System.out.println("총 수익률은 " + 100*(incomeMoney - money) / money + "%입니다.");
    }
}
