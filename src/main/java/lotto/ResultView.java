package lotto;

public class ResultView {
    public static void printLotto(LottoGame lottoGame) {
        for (Lotto lotto : lottoGame.getPurchasedLotto()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void statistic(GameResult result, int money) {
        System.out.println("당첨 통계");
        System.out.println("-----------------------------------------------");
        System.out.println("3개일치 (5000원) - " + result.getRankCount(Rank.FIFTH));
        System.out.println("4개일치 (50000원) - " + result.getRankCount(Rank.FOURTH));
        System.out.println("5개일치 (1500000원) - " + result.getRankCount(Rank.THIRD));
        System.out.println("5개일치, 보너스 볼  일치 (30000000원) - " + result.getRankCount(Rank.SECOND));
        System.out.println("6개일치 (2000000000원) - " + result.getRankCount(Rank.FIRST));
        System.out.println();
        System.out.println("총 수익률은 " + rateOfReturn(getTotal(result), money) + "%입니다.");
    }

    static String rateOfReturn(int total, int money) {
        return Long.toUnsignedString(Long.parseUnsignedLong(total + "00") / money);
    }

    static int getTotal(GameResult result) {
        int total = 0;
        for (Rank rank : Rank.values()) {
            total += result.getRankCount(rank) * rank.getWinningMoney();
        }
        return total;
    }
}
