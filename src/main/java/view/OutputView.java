package view;

import domain.LottoBundle;
import domain.result.LottoResults;

public class OutputView {

    public static void printPurchaseHistory(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getPurchaseHistory());
    }

    public static void printResult(int amount, LottoResults results) {
        //여기서 애널리스트를 불러서 관련 계산을 하는걸로 하면 어떨까? 아니면 result가 모든걸 들고 있으니 result에게 위임하는게?
        //필요한 정보가 무엇인가? 1. 랭크마다 몇개 있는가? 랭크 카운트 2. 얼마나 수익을 거뒀나(투자 대비 얻은 돈은 얼마인가)
        String resultMessage = buildTitle() + results.toString() + buildProfitContent(results.calcLottoProfit(amount));
        System.out.println(resultMessage);
    }

    private static String buildTitle() {
        return "당첨 통계\n" + "---------\n";
    }

    private static String buildProfitContent(int profit) {
        return "총 수익률은 " + profit + "%입니다.";
    }
}