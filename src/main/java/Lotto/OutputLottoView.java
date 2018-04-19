package Lotto;

public class OutputLottoView {

    public static void printNumberOfLottoPurchase(LottoGame lottoGame) {
        System.out.println(lottoGame.getCount() + "개를 구매했습니다.");
    }

    public static void printPurchaseLotto(LottoGame lottoGame) {
        for (int i = 0; i < lottoGame.getCount(); i++) {
            System.out.println(lottoGame.lottoNumber());
        }
    }

    public static void winStat(LottoGameResult lottoGameResult, int money) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + lottoGameResult.getThreeMatchCount() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoGameResult.getFourMatchCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoGameResult.getFiveMatchCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoGameResult.getSixMatchCount() + "개");
        System.out.println("총 수익률은 " + lottoGameResult.getYield(money) + "%입니다.");
    }

}