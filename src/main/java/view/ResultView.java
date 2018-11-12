package view;

import domain.Lotto;
import domain.LottoryManager;
import domain.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ResultView {
    public static void view(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void winView(LottoryManager manager) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        Arrays.stream(Rank.values()).sorted(Comparator.reverseOrder())
                .map(value -> result(value, manager))
                .forEach(System.out::println);

        System.out.println("총 수익률은 " + manager.yield() + "%입니다.");
    }

    public static String result(Rank value, LottoryManager manager) {
        return value.getTrueNum()
                + "개 일치"
                + ifBouns(value)
                + " ("
                + value.getMoney()
                + " 원)- "
                + manager.findRank(value)
                + "개";
    }

    private static String ifBouns(Rank value) {
        return value == Rank.TWO ? ", 보너스 볼 일치" : "";
    }
}
