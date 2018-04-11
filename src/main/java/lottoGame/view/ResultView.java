package lottoGame.view;

import lottoGame.domain.Lotto;
import lottoGame.domain.LottoStaticResult;

public class ResultView {

    public static void printLottoTiketCnt(Lotto[] lottoes) {
        int lottoTiketCnt = 0;

        if(lottoes != null) {
            lottoTiketCnt = lottoes.length;
        }

        System.out.println(lottoTiketCnt+"개를 구매했습니다.");
    }

    public static void printLottoNumbers(Lotto[] lottoes) {

        for(Lotto lotto : lottoes) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printPrizeStaicResult(LottoStaticResult lottoStaticResult,int investment) {
        System.out.println();

        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계\n");
        sb.append("---------\n");
        sb.append("3개 일치 (").append(LottoStaticResult.THREE_LUCKY_PRIZE).append(")- ").append(lottoStaticResult.getThreeLuckyNum()).append("개\n");
        sb.append("4개 일치 (").append(LottoStaticResult.FOUR_LUCKY_PRIZE).append(")- ").append(lottoStaticResult.getFourLuckyNum()).append("개\n");
        sb.append("5개 일치 (").append(LottoStaticResult.FIVE_LUCKY_PRIZE).append(")- ").append(lottoStaticResult.getFiveLuckyNum()).append("개\n");
        sb.append("6개 일치 (").append(LottoStaticResult.SIX_LUCKY_PRIZE).append(")- ").append(lottoStaticResult.getSixLuckyNum()).append("개\n");
        sb.append("총 수익률은 ").append(lottoStaticResult.getProfitPercent(investment)).append("% 입니다.\n");

        System.out.println(sb.toString());
    }
}
