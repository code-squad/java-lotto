package lottoGame.view;

import lottoGame.model.Money;
import lottoGame.model.Rank;

import java.util.Arrays;

public class OutputView {

    public static void printLottoNumbers (String[] numbers) {
        System.out.println("[" + String.join(" ,", Arrays.asList(numbers)) + "]");
    }

    public static void printLottoGameResult(int money) {
        System.out.println("당첨통계");
        System.out.println("---------");

        int rewardSum = 0;
        for(Rank rank : Rank.values()) {
            System.out.println(rank.getMatchCnt()+"개 일치 (" + rank.getReward() + ") - " + rank.getCnt() + "개 일치");
            rewardSum += rank.getReward()*rank.getCnt();
        }

        System.out.println("총 수익률은 : " + Money.getLottoProfitPer(rewardSum,money) + "%입니다.");
    }
}
