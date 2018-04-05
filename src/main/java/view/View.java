package view;

import lotto.Lotto;
import lotto.LottoGame;
import profit.Profit;
import rank.Rank;
import result.Result;

import java.util.HashMap;
import java.util.List;

public class View {
    public static void showNumbers(int inputMoney) {
        int num = inputMoney / 1000;
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void printResult(Result result) {
        Rank [] ranks = Rank.values();
        Profit profit = new Profit();
        for(int i = ranks.length - 2; i >= 0; i--)
            System.out.println(ranks[i].getCountOfMatch() + "개 일치 (" + ranks[i].getWinningMoney() + "원)- " + Result.getFinalResult().get(ranks[i]) + "개");
        System.out.println("총 수익률은 " + profit.percent(result.getRanks()) + "입니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getLotto());
        }
    }
}
