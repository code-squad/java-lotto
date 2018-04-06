package view;

import lotto.Lotto;
import rank.Rank;
import result.Result;
import java.util.List;

public class View {
    public static void showNumbers(int inputMoney, int manualNumber) {
        System.out.println("수동으로 " + manualNumber + "장, 자동으로 " + ((inputMoney / 1000) - manualNumber) + "개를 구매했습니다.");
    }

    public static void printResult(Result result) {
        Rank [] ranks = Rank.values();
        for(int i = ranks.length - 2; i >= 0; i--)
            System.out.println(ranks[i].getCountOfMatch() + "개 일치 (" + ranks[i].getWinningMoney() + "원)- " + Result.getFinalResult().get(ranks[i]) + "개");
        System.out.println("총 수익률은 " + result.getPercent() + "입니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getLotto());
        }
    }
}
