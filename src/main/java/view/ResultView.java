package view;

import domain.Lotto;
import domain.WinningRules;


import java.util.List;
import java.util.Map;

public class ResultView {
    public static void view(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void winView(WinningRules userWinnerLottos, int input) {
        long percent = getPercent(userWinnerLottos, input);
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + userWinnerLottos.ranking(3) + "개");
        System.out.println("4개 일치 (50000원)- " + userWinnerLottos.ranking(4) + "개");
        System.out.println("5개 일치 (1500000원)- " + userWinnerLottos.ranking(5) + "개");
        System.out.println("6개 일치 (2000000000원)- " + userWinnerLottos.ranking(6) + "개");
        System.out.println("총 수익률은 "+ percent +"%입니다.");

    }

    private static long getPercent(WinningRules winningRules, int input) {
        return  (100L *(( 5000 * winningRules.ranking(3)
                        + 50000 * winningRules.ranking(4)
                        + 1500000 * winningRules.ranking(5)
                        + 2000000000 * winningRules.ranking(6) ) / input));
    }
}
