package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.LottoUtil;

import java.util.List;

public class ResultView {
    private static final int PRICE = 1000;

    public static int price(int input) {
        return input / PRICE;
    }

    public static void count(int input) {
        System.out.println(price(input) + "개를 구매했습니다.");
    }

    public static void lottoOutput(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void prizeStatement() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void prizeRank(List<Integer> pageSize, int amount) {
        List<Rank> ranks = LottoUtil.ranks();
        for (int i = 0; i < ranks.size(); i++) {

            if(i == 3){
                printBonus(pageSize.get(i), ranks.get(i));
            }

            if(i != 3) {
                printRank(pageSize.get(i), ranks.get(i));
            }
        }
        System.out.println("총 수익률은 " + amount + "%입니다.");
    }

    private static void printRank(int pageSize, Rank ranks) {
        System.out.println(ranks.getCountOfMatch() + "개 일치 ("
                + ranks.getWinningMoney() + "원) - " + pageSize);
    }

    private static void printBonus(int pageSize, Rank ranks) {
        System.out.println(ranks.getCountOfMatch() + "개 일치, 보너스 볼 일치 ("
                + ranks.getWinningMoney() + "원) - " + pageSize);
    }
}