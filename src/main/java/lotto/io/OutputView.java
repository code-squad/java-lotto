package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.util.LottoRecorder;

import java.util.List;
import java.util.stream.Stream;

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
        Stream.of(LottoRank.values())
                .filter(lottoRank -> !lottoRank.equals(LottoRank.REST))
                .forEach(lottoRank -> 
                    System.out.println(String.format("%d개 일치(%d원)- %d개", lottoRank.getMatchingCount(), lottoRank.getPrice(), lottoRecorder.getLottoCount(lottoRank)))
                );
        System.out.println(String.format("총 수익률은 %d입니다.",lottoRecorder.getProfitRatio()));
    }
}
