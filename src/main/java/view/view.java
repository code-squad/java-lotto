package view;

import lotto.Lotto;
import lotto.LottoGame;

import java.util.List;

public class view {
    public static void showNumbers(int inputMoney) {
        int num = inputMoney / 1000;
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void resultView(List<Lotto> lottos, Lotto winningNumber) {
        LottoGame game = new LottoGame();
        List<Integer> counts = game.match(lottos, winningNumber);
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + game.getCount(counts, 3) + "개");
        System.out.println("4개 일치 (50000원) - " + game.getCount(counts, 4) + "개");
        System.out.println("5개 일치 (150000원) - " + game.getCount(counts, 5) + "개");
        System.out.println("6개 일치 (2000000000원) - " + game.getCount(counts, 6) + "개");
    }
}
