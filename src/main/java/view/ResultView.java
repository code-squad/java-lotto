package view;

import domain.Lotto;
import domain.Rank;

import java.util.ArrayList;

public class ResultView {
    public static void view(ArrayList<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void winView(Rank rank, int input) {
        long percent = getPercent(rank, input);
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + rank.ranking(3) + "개");
        System.out.println("4개 일치 (50000원)- " + rank.ranking(4) + "개");
        System.out.println("5개 일치 (1500000원)- " + rank.ranking(5) + "개");
        System.out.println("6개 일치 (2000000000원)- " + rank.ranking(6) + "개");
        System.out.println("총 수익률은 "+ percent +"%입니다.");
    }

    private static long getPercent(Rank rank, int input) {
        return (long) (100 *( 5000 * rank.ranking(3)
                        + 50000 * rank.ranking(4)
                        + 1500000 * rank.ranking(5)
                        + 2000000000 * rank.ranking(6) ) / input);
    }
}
