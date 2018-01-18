package view;

import model.Lotto;
import model.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoNumbers(List<Lotto> result){
        for (Lotto lotto : result) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printNumber(Integer number){
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void printResult(Map<Rank, Integer> result){
        for (Rank rank : result.keySet()) {
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원) " + result.get(rank) + "개");
        }
    }

    public static void printStatics(Double percentage){
        System.out.println("수익률은 " + percentage + "% 입니다.");
    }

    public static void printBuyStatus(Integer totalNumbertoBuy, Integer numberOfHandOperatedLotto) {
        System.out.println("수동으로 " + numberOfHandOperatedLotto + "장, 자동으로 " + (totalNumbertoBuy - numberOfHandOperatedLotto) + "개를 구매했습니다.");
    }
}
