package lottoGame.view;

import lottoGame.domain.Lotto;
import lottoGame.domain.LottoRank;
import lottoGame.domain.LottoStaticResult;

import java.util.List;

public class ResultView {

    public static void printLottoTiketCount(List<Lotto> lottoes,int handOperatedLottoCount) {
        System.out.println();
        int totalLottoTiketCount = 0;

        if(lottoes != null) {
            totalLottoTiketCount = lottoes.size();
        }

        int autoLottoTiketCount = lottoes.size() - handOperatedLottoCount;

        System.out.println("수동으로 "+handOperatedLottoCount+"장, "+"자동으로 "+autoLottoTiketCount+"개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottoes) {

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

        for(LottoRank lottoRank:LottoRank.values()) {
            if (isSecondRank(lottoStaticResult, sb, lottoRank))
                continue;
            if (isNotMissRank(lottoRank))
                sb.append(lottoRank.getCountOfMatch()).append("개 일치 (").append(lottoRank.getWinningMoney()).append("원)- ").append(lottoStaticResult.getLottoStatisticsCountResult(lottoRank)).append("개\n");
        }

        sb.append("총 수익률은 ").append(lottoStaticResult.getProfitPercent(investment)).append("% 입니다.\n");
        System.out.println(sb.toString());
    }

    private static boolean isNotMissRank(LottoRank lottoRank) {
        return lottoRank != LottoRank.MISS;
    }

    private static boolean isSecondRank(LottoStaticResult lottoStaticResult, StringBuilder sb, LottoRank lottoRank) {
        if(lottoRank == LottoRank.SECOND) {
            sb.append(lottoRank.getCountOfMatch()).append("개 일치, 보너스 볼 일치 (").append(lottoRank.getWinningMoney()).append("원)- ").append(lottoStaticResult.getLottoStatisticsCountResult(lottoRank)).append("개\n");
            return true;
        }
        return false;
    }
}
