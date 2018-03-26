package view;

import domain.Lotto;
import domain.LottoBundle;
import dto.LottoResult;

public class OutputView {

    public static void printPurchaseHistory(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getPurchaseHistory());
    }

    public static void printResult(LottoResult result) {
        String resultMessage = buildTitle() + analyzeResult(result) + analyzeProfit(result);
        System.out.println(resultMessage);
    }

    private static String buildTitle() {
        return "당첨 통계\n" + "---------\n";
    }

    private static String analyzeResult(LottoResult result) {
        StringBuilder builder = new StringBuilder();
        int displayLimit = Lotto.LOTTO_NUM - Prize.getSize();
        for (int matchPoint = Lotto.LOTTO_NUM; matchPoint > displayLimit; matchPoint--) {
            builder.append(buildResultMessage(Prize.of(matchPoint), result.calcRightMatchPoint(matchPoint)));
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String buildResultMessage(Prize prize, int prizeCount) {
        return prize.getMatchPoint() + "개 일치 (" + prize.getPrize() + "원) - " + prizeCount + "개";
    }

    private static String analyzeProfit(LottoResult result) {
        // 총 상금액 구해서 result에 구해달라고 하는거지
        return "총 수익률은 " + "" + "% 입니다.";
    }
}

enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int matchPoint;
    private long prize;

    Prize(int matchPoint, long prize) {
        this.matchPoint = matchPoint;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchPoint() {
        return matchPoint;
    }

    private boolean isMatchPoint(int matchPoint) {
        return this.matchPoint == matchPoint;
    }

    public static Prize of(int matchPoint) {
        Prize searchPrize = null;
        for (Prize prize : Prize.values()) {
            if (prize.isMatchPoint(matchPoint)) {
                searchPrize = prize;
                break;
            }
        }
        return searchPrize;
    }

    public static int getSize() {
        return Prize.values().length;
    }
}
