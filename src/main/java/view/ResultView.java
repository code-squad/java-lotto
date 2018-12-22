package view;

import dto.LottoDto;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottos(List<LottoDto> lottos) {
        lottos.stream().forEach(System.out::println);
    }

    public static void printResult(Map<Integer, Integer> result) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + result.get(3) + "개");
        System.out.println("4개 일치 (50000원)- " + result.get(4) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.get(5) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.get(6) + "개");
    }

    public static void printResultRatio(int ratio) {
        System.out.println("총 수익률은 " + ratio + "%입니다.");
    }

}
