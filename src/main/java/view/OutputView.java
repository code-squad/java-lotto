package view;

import domain.Lotto;
import domain.LottoBundle;
import dto.LottoResult;
import utils.Prize;

public class OutputView {

    public static void printPurchaseHistory(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getPurchaseHistory());
    }

    public static void printResult(LottoResult result) {
        String resultMessage = buildTitle() + analyzeResult(result);
        System.out.println(resultMessage);
    }

    private static String buildTitle() {
        return "당첨 통계\n" + "---------\n";
    }

    private static String analyzeResult(LottoResult result) {
        int displayLimit = Lotto.LOTTO_NUM - Prize.getSize();
        long money = 0;
        StringBuilder builder = new StringBuilder();
        for (int matchPoint = Lotto.LOTTO_NUM; matchPoint > displayLimit; matchPoint--) {
            Prize prize = Prize.of(matchPoint);
            int matchNum = result.calcMatchNum(matchPoint);
            builder.append(buildResultMessage(prize, matchNum));
            money += getPrizeMoney(prize, matchNum);
        }
        builder.append(analyzeProfit(result, money));
        return builder.toString();
    }

    private static int getPrizeMoney(Prize prize, int matchNum) {
        if (matchNum == 0) {
            return 0;
        }
        int money = prize.getPrize();
        return money * matchNum;
    }

    private static String buildResultMessage(Prize prize, int prizeCount) {
        return prize.getMatchPoint() + "개 일치 (" + prize.getPrize() + "원) - " + prizeCount + "개\n";
    }

    private static String analyzeProfit(LottoResult result, long prizeMoney) {
        return "총 수익률은 " + result.calcLottoProfit(prizeMoney) + "% 입니다.";
    }
}