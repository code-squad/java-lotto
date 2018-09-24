package Lotto;

public class OutputLottoView {

    public static void printNumberOfLottoPurchase(LottoGame lottoGame) {
        System.out.println("수동으로 " + lottoGame.getManualCount() + "장, 자동으로 " + lottoGame.getAutoCount() + "장 구매했습니다.");
    }

    public static void printPurchaseLotto(LottoGame lottoGame) {
        for (int i = 0; i < lottoGame.getTotalCount(); i++) {
            System.out.println(lottoGame.getUserLottoNumber(i));
        }
    }

    public static void winStat(LottoGameResult lottoGameResult, Money money) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + lottoGameResult.getFifthPrizeCount() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoGameResult.getFourthPrizeCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoGameResult.getThirdPrizeCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + lottoGameResult.getSecondPrizeCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoGameResult.getFirstPrizeCount() + "개");
        System.out.println("총 수익률은 " + lottoGameResult.getYield(money) + "%입니다.");
    }

}