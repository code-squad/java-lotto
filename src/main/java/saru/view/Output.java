package saru.view;

import saru.Result;
import saru.domain.LottoLine;

import java.util.List;

// SonarLint StandOutput warning 방지용
@java.lang.SuppressWarnings("squid:S106")
public class Output {
    private static final int ONE_LOTTO = 1000;
    private static final int PERCENT = 100;
    private static final int THREE_PRIZE = 5000;
    private static final int FOUR_PRIZE = 50000;
    private static final int FIVE_PRIZE = 1500000;
    private static final int SIX_PRIZE = 2000000000;

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
        return PERCENT * (sumMoney / (this.buyNum * ONE_LOTTO));
    }

    private int calcSumMoney() {
        int threeHitMoney = result.getThreeHit() * THREE_PRIZE;
        int fourHitMoney = result.getFourHit() * FOUR_PRIZE;
        int fiveHitMoney = result.getFiveHit() * FIVE_PRIZE;
        int sixHitMoney = result.getSixHit() * SIX_PRIZE;

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
