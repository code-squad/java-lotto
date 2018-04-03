package saru.view;

import saru.Rank;
import saru.Result;
import saru.domain.LottoLine;

import java.util.List;

// SonarLint StandOutput warning 방지용
@java.lang.SuppressWarnings("squid:S106")
public class Output {
    private Result result;

    public Output(Result result) {
        this.result = result;
    }

    public void printStatus() {
        System.out.println("\n당첨 통계\n---------");

        System.out.printf("3개 일치 (5000원)- %d개\n4개 일치 (50000원)- %d개\n" +
                        "5개 일치 (1500000원)- %d개\n5개 일치, 보너스 볼 일치(30000000원) - %d개\n" +
                        "6개 일치 (2000000000원)- %d개\n"
                , result.getRankHitNum(Rank.FIFTH), result.getRankHitNum(Rank.FOURTH),
                result.getRankHitNum(Rank.THIRD), result.getRankHitNum(Rank.SECOND),
                result.getRankHitNum(Rank.FIRST));

        System.out.printf("총 수익률은 %d%%입니다.", result.calcIncome());
    }

    public static void printCreatedNum(List<LottoLine> lottoLines) {
        // 생성된 번호 출력
        for (LottoLine lottoLine : lottoLines) {
            System.out.println(lottoLine);
        }
        System.out.println();
    }
}
