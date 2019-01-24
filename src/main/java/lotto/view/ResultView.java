package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.LottoUtil;

import java.util.List;

public class ResultView {
    private static final int PRICE = 1000;

    public static int price(int input){
        return input / PRICE;
    }

    public static void count(int input){
        System.out.println(price(input)+"개를 구매했습니다.");
    }

    public static void lottoOutput(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void prizeStatement(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void prizeRank(List<Integer> pageSize, double amount){
        List<Rank> ranks = LottoUtil.ranks();
        for (int i = 0; i < ranks.size(); i++) {
            System.out.println(ranks.get(i).getCountOfMatch() +"개 일치 ("
                            + ranks.get(i).getWinningMoney()+"원) - "+pageSize.get(i));
        }

        System.out.println("총 수익률은 "+amount+"%입니다.");
    }
}