package saru.view;

import saru.Result;
import saru.domain.LottoLine;

import java.util.List;

// SonarLint StandOutput warning 방지용
@java.lang.SuppressWarnings("squid:S106")
public class Output {
    private Result result;
    private int buyNum;

    public Output(Result result, int buyNum) {
        this.result = result;
        this.buyNum = buyNum;
    }

    public void printStatus() {
        System.out.println("당첨 통계\n---------");

        System.out.printf("3개 일치 (5000원)- %d개\n4개 일치 (50000원)- %d개\n" +
                        "5개 일치 (1500000원)- %d개\n6개 일치 (2000000000원)- %d개\n"
                , result.getThreeHit(), result.getFourHit(),
                result.getFiveHit(), result.getSixHit());

        System.out.printf("총 수익률은 %d%%입니다.", calcIncome());
    }

    public long calcIncome() {
        long sumMoney = calcSumMoney();
        return 100 * (sumMoney / (this.buyNum * 1000));
    }

    private int calcSumMoney() {
        int threeHitMoney = result.getThreeHit() * 5000;
        int fourHitMoney = result.getFourHit() * 50000;
        int fiveHitMoney = result.getFiveHit() * 1500000;
        int sixHitMoney = result.getSixHit() * 2000000000;

        return threeHitMoney + fourHitMoney + fiveHitMoney + sixHitMoney;
    }

    public static void printCreatedNum(List<LottoLine> lottoLines) {
        // 생성된 번호 출력
        for (LottoLine lottoLine : lottoLines) {
            System.out.println(lottoLine);
        }
        System.out.println();
    }
}
