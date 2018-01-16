package model;

import lotto.Lotto;

import java.util.List;

public class ResultView {
    public static void printLottoNumbers(List<Lotto> result){
        for (Lotto lotto : result) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printNumber(Integer number){
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void printResult(List<Integer> result){
        System.out.println("3개 일치 (5000원) " + result.get(0) + "개");
        System.out.println("4개 일치 (50000원) " + result.get(1) + "개");
        System.out.println("5개 일치 (1500000원) " + result.get(2) + "개");
        System.out.println("6개 일치 (2000000000원) " + result.get(3) + "개");
    }

    public static void printStatics(Double percentage){
        System.out.println("수익률은 " + percentage + "% 입니다.");
    }
}
