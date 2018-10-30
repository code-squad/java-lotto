package lotto.view;

import lotto.domain.LottoManager;
import lotto.domain.Rank;

import java.util.Arrays;

public class ResultView {
    public static void winList(LottoManager lottoManager) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        Arrays.stream(Rank.values())
                .map(rank -> rank.getCountOfMatch() + "개 일치" + findBonus(rank) + "(" + rank.getWinningMoney() + "원)-" + lottoManager.getRank(rank) + "개")
                .forEach(System.out::println);
//
//        for (Rank value : Rank.values()) {
//            if(value == Rank.SECOND){
//                System.out.println(value.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + value.getWinningMoney() + "원)-" + lottoManager.getRank(value) + "개");
//            }
//            if(value != Rank.SECOND){
//                System.out.println(value.getCountOfMatch() + "개 일치 (" + value.getWinningMoney() + "원)-" + lottoManager.getRank(value) + "개");
//            }
//        }


//        System.out.println(Rank.FIFTH.getCountOfMatch() + "개 일치 (" + Rank.FIFTH.getWinningMoney() + "원)- " + lottoManager.getFifthRank() + "개");
//        System.out.println(Rank.FOURTH.getCountOfMatch() + "개 일치 (" + Rank.FOURTH.getWinningMoney() + "원)- " + lottoManager.getFourthRank() + "개");
//        System.out.println(Rank.THIRD.getCountOfMatch() + "개 일치 (" + Rank.THIRD.getWinningMoney() + "원)- " + lottoManager.getThirdRank() + "개");
//        System.out.println(Rank.SECOND.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + Rank.SECOND.getWinningMoney() + "원)-" + lottoManager.getSecondRank() + "개");
//        System.out.println(Rank.FIRST.getCountOfMatch() + "개 일치 (" + Rank.FIRST.getWinningMoney() + "원)- " + lottoManager.getFirstRank() + "개");
        System.out.println("총 수익률은 " + lottoManager.yield() + "%입니다.");
    }

    public static String findBonus(Rank value) {
        if (value == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }

    public static void printLotto(LottoManager lottoManager) {
        System.out.println(lottoManager.getSize() + "개를 구매했습니다.");
        for (int i = 0; i < lottoManager.getSize(); i++) {
            System.out.println(lottoManager.getLotto(i));
        }
    }
}
