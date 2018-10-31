package lotto.view;

import lotto.domain.LottoManager;
import lotto.domain.Rank;

import java.util.Arrays;

public class ResultView {
    public static void winList(LottoManager lottoManager, long yield) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        Arrays.stream(Rank.values())
                .map(rank -> rank.getCountOfMatch() + "개 일치" + findBonus(rank) + "(" + rank.getWinningMoney() + "원)-" + lottoManager.getRank(rank) + "개")
                .forEach(System.out::println);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    public static String findBonus(Rank value) {
        if (value == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }

    public static void printLotto(LottoManager lottoManager) {
        System.out.println(lottoManager.getSize() + "개를 구매했습니다.");
        for (int i = 0; i < lottoManager.getSize(); i++) {
            System.out.println(lottoManager.getLotto(i));
        }
    }
}
