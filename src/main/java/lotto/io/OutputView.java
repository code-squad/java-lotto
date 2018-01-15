package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.util.LottoRecorder;

import java.util.List;

public class OutputView {
    public static void printLotto(List<Lotto> lottoList) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoList.size()));
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printResult(LottoRecorder lottoRecorder) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("%d개 일치(%d원)- %d개", LottoRank.FOURTH.getMatchingCount(), LottoRank.FOURTH.getPrice(), lottoRecorder.getLottoCount(LottoRank.FOURTH)));
        System.out.println(String.format("%d개 일치(%d원)- %d개", LottoRank.THIRD.getMatchingCount(), LottoRank.THIRD.getPrice(), lottoRecorder.getLottoCount(LottoRank.THIRD)));
        System.out.println(String.format("%d개 일치(%d원)- %d개", LottoRank.SECOND.getMatchingCount(), LottoRank.SECOND.getPrice(), lottoRecorder.getLottoCount(LottoRank.SECOND)));
        System.out.println(String.format("%d개 일치(%d원)- %d개", LottoRank.JACKPOT.getMatchingCount(), LottoRank.JACKPOT.getPrice(), lottoRecorder.getLottoCount(LottoRank.JACKPOT)));
        System.out.println(String.format("총 수익률은 %d입니다.",lottoRecorder.getProfitRatio()));
    }
}
