package lotto;

public class ResultView {
    public static void printLotto(LottoGame lottoGame) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다\n",
                lottoGame.getManualLottoCount(),
                lottoGame.getAutomaticLottoCount());

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
        System.out.println("총 수익률은 " + result.rateOfReturn(money) + "%입니다.");
    }
}
