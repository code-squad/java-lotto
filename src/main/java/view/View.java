package view;

import lotto.Lotto;
import lotto.LottoGame;

import java.util.List;

public class View {
    public static void showNumbers(int inputMoney) {
        int num = inputMoney / 1000;
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void resultView(List<Integer> winCounts) {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winCounts.get(0) + "개");
        System.out.println("4개 일치 (50000원) - " + winCounts.get(1) + "개");
        System.out.println("5개 일치 (150000원) - " + winCounts.get(2) + "개");
        System.out.println("6개 일치 (2000000000원) - " + winCounts.get(3) + "개");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getLotto());
        }
    }
}
