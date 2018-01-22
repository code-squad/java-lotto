package lotto.io;

import lotto.domain.Lotteries;
import lotto.domain.LottoRank;
import lotto.util.LottoRecorder;

import java.util.stream.Stream;

public class OutputView {
    public static void printLotto(Lotteries manualLotto, Lotteries autoLotto) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d장를 구매했습니다.", manualLotto.size(), autoLotto.size()));
        Stream.concat(manualLotto.stream(), autoLotto.stream())
                .forEach(lotto -> System.out.println(lotto));
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