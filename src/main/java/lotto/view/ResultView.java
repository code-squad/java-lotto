package lotto.view;

import lotto.InvalidInputException;
import lotto.domain.Lotto;
import lotto.domain.LottoPlay;
import lotto.domain.Rank;

import java.util.List;

public class ResultView {
    private static final int PRICE = 1000;
    private static final int FIFTH_KEY = 3;
    private static final String WON = "원) - ";

    public static int price(int input) throws InvalidInputException {
        if (input % 1000 != 0) {
            throw new InvalidInputException("금액을 잘못 입력하였습니다.");
        }

        return input / PRICE;
    }

    private static int randomPrice(int price, int manualNum) {
        return price - manualNum;
    }

    public static void count(int price, int manualNum) {
        System.out.println();
        System.out.println("수동으로 " + manualNum + "장, 자동으로 " + randomPrice(price, manualNum) + "장을 구매했습니다.");
    }

    public static void lottoOutput(List<Lotto> lottos, List<Lotto> manualLottos) {
        for (Lotto manualLotto : manualLottos) {
            System.out.println(manualLotto);
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void prizeStatement() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void prizeRank(List<Integer> pageSize, long amount, List<Rank> ranks) {
        for (int i = 0; i < ranks.size(); i++) {

            if (i == FIFTH_KEY) {
                printBonus(pageSize.get(i), ranks.get(i));
            }

            if (i != FIFTH_KEY) {
                printRank(pageSize.get(i), ranks.get(i));
            }
        }
        System.out.println("총 수익률은 " + amount + "%입니다.");
    }

    private static void printRank(int pageSize, Rank ranks) {
        System.out.println(ranks.getCountOfMatch() + "개 일치 ("
                + ranks.getWinningMoney() + WON + pageSize);
    }

    private static void printBonus(int pageSize, Rank ranks) {
        System.out.println(ranks.getCountOfMatch() + "개 일치, 보너스 볼 일치 ("
                + ranks.getWinningMoney() + WON + pageSize);
    }
}