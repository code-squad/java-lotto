package lotto;

import java.util.List;

public class ResultView {
    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    private static final int THREE_MATCH_MONEY = 5000;
    private static final int FOUR_MATCH_MONEY = 50000;
    private static final int FIVE_MATCH_MONEY = 1500000;
    private static final int SIX_MATCH_MONEY = 2000000000;

    public static void printLotto(LottoGame lottoGame) {
        for (Lotto lotto : lottoGame.lottos) {
            System.out.println(lotto.numbers);
        }
        System.out.println();
    }

    public static void statistic(GameResult result, int money) {
        System.out.println("당첨 통계");
        System.out.println("-----------------------------------------------");
        System.out.println("3개일치 (5000원) - " + getWinLottosCount(result, THREE_MATCH));
        System.out.println("4개일치 (50000원) - " + getWinLottosCount(result, FOUR_MATCH));
        System.out.println("5개일치 (1500000원) - " + getWinLottosCount(result, FIVE_MATCH));
        System.out.println("6개일치 (2000000000원) - " + getWinLottosCount(result, SIX_MATCH));
        System.out.println();
        System.out.println("총 수익률은 " + rateOfReturn(getTotal(result), money) + "%입니다.");
    }

    private static int rateOfReturn(int total, int money) {
        return total * 100 / money;
    }

    private static int getTotal(GameResult result) {
        int total = 0;
        total += getWinLottosCount(result, THREE_MATCH) * THREE_MATCH_MONEY;
        total += getWinLottosCount(result, FOUR_MATCH) * FOUR_MATCH_MONEY;
        total += getWinLottosCount(result, FIVE_MATCH) * FIVE_MATCH_MONEY;
        total += getWinLottosCount(result, SIX_MATCH) * SIX_MATCH_MONEY;
        return total;
    }

    private static int getWinLottosCount(GameResult result, int threeMatch) {
        return getLottoListCount(result, threeMatch).size();
    }

    private static List<Lotto> getLottoListCount(GameResult result, int threeMatch) {
        return result.winLottos.get(threeMatch);
    }
}
