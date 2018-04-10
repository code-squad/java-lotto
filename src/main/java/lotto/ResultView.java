package lotto;

public class ResultView {
    static final int THREE_MATCH = 3;
    static final int FOUR_MATCH = 4;
    static final int FIVE_MATCH = 5;
    static final int SIX_MATCH = 6;

    private static final int THREE_MATCH_MONEY = 5000;
    private static final int FOUR_MATCH_MONEY = 50000;
    private static final int FIVE_MATCH_MONEY = 1500000;
    private static final int SIX_MATCH_MONEY = 2000000000;

    public static void printLotto(LottoGame lottoGame) {
        for (Lotto lotto : lottoGame.getPurchasedLotto()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void statistic(GameResult result, int money) {
        System.out.println("당첨 통계");
        System.out.println("-----------------------------------------------");
        System.out.println("3개일치 (5000원) - " + getWinningCount(result, THREE_MATCH));
        System.out.println("4개일치 (50000원) - " + getWinningCount(result, FOUR_MATCH));
        System.out.println("5개일치 (1500000원) - " + getWinningCount(result, FIVE_MATCH));
        System.out.println("6개일치 (2000000000원) - " + getWinningCount(result, SIX_MATCH));
        System.out.println();
        System.out.println("총 수익률은 " + rateOfReturn(getTotal(result), money) + "%입니다.");
    }

    private static int getWinningCount(GameResult result, int matchNumber) {
        return result.getWinningCount(matchNumber);
    }

    private static int rateOfReturn(int total, int money) {
        return total * 100 / money;
    }

    private static int getTotal(GameResult result) {
        int total = 0;
        total += getWinningCount(result, THREE_MATCH) * THREE_MATCH_MONEY;
        total += getWinningCount(result, FOUR_MATCH) * FOUR_MATCH_MONEY;
        total += getWinningCount(result, FIVE_MATCH) * FIVE_MATCH_MONEY;
        total += getWinningCount(result, SIX_MATCH) * SIX_MATCH_MONEY;
        return total;
    }
}
