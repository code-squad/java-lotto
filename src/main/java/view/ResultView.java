package view;

import domain.BuyInfo;
import domain.Lottos;
import domain.Money;
import domain.WinningLottos;

import static domain.LottoSeller.LOTTO_PRICE;

public class ResultView {

    public static void showLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void showResult(WinningLottos winningLottos, Money investment) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println(winningLottos.toString());
        System.out.println("총 수익률은 " + winningLottos.getProfitPercentage(investment) + "%입니다.");
    }

    public static void showNumOfBuyLotto(BuyInfo buyInfo) {
        int totalLottoNo = buyInfo.getPurchasableTotalQuantity(LOTTO_PRICE);
        int autoLottoNo = buyInfo.getPurchasableQuantity(LOTTO_PRICE);
        int manualLottoNo = totalLottoNo - autoLottoNo;

        System.out.println("수동으로 " + manualLottoNo + "장, 자동으로 " + autoLottoNo + "개를 구매했습니다.");
    }
}
