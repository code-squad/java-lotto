package view;

import domain.BuyInfo;
import domain.Lottos;
import domain.WinningLottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultView {
    public static List<String> splitToString(String lottosToString) {
        if(lottosToString.isEmpty())
            return new ArrayList<>();

        List<String> splittedString = Arrays.asList(lottosToString.split("\n"));

        return splittedString;
    }
    public  static void showNumOfBoughtLottos(BuyInfo buyInfo) {
        System.out.println("수동으로 " + buyInfo.getNumOfManualLottos() + "장," +
                " 자동으로 " + buyInfo.getBuyableNumberOfAutoLottos() + "개를 구매했습니다.");
    }

    public static void showLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void showResult(WinningLottos winningLottos) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println(winningLottos.toString());
        System.out.println("총 수익률은 " + winningLottos.getProfitPercentage() + "%입니다.");
    }
}
