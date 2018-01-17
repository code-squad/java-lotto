package view;

import domain.Lotto;
import dto.LottoResult;

import java.util.List;

public class OutputView {

    public static void printMyLotto(List<Lotto> lottos){
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).toString());
        }
    }

    public static void printCountOfWinLotto(LottoResult lottoResult){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + lottoResult.getResult().get(3));
        System.out.println("4개 일치 (50000원) - " + lottoResult.getResult().get(4));
        System.out.println("5개 일치 (1500000원) -  " + lottoResult.getResult().get(5));
        System.out.println("6개 일치 (2000000000원) - " + lottoResult.getResult().get(6));
        System.out.println("당신의 수익률은 " + lottoResult.getRate() + "%입니다.");
    }

    public static void printAmountLotto(int amount) {
        System.out.println(amount + "개 구입하였습니다.");
    }
}
