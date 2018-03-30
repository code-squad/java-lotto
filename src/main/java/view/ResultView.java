package view;

import domain.Lotto;
import domain.Lottos;

import java.util.List;

//public class ResultView {
//    public static void printResult(Lottos lottos, Lotto winningLotto) {
//        List<Integer> results = lottos.getResult(winningLotto);
//        System.out.println("당첨 통계");
//        System.out.println("-------------------------------");
//        System.out.println(String.format("3개 일치 : (5000원) - %d개", results.get(0)));
//        System.out.println(String.format("4개 일치 : (50000원) - %d개", results.get(1)));
//        System.out.println(String.format("5개 일치 : (150000원) - %d개", results.get(2)));
//        System.out.println(String.format("6개 일치 : (2000000000원) - %d개", results.get(3)));
//        System.out.println(String.format("총 수익률은 %d%%입니다.", lottos.calcProfit(winningLotto)));
//    }
//
//    public static void printLottos(Lottos lottos) {
//        print(lottos.toString());
//    }
//
//    private static void print(String s) {
//        System.out.println(s);
//    }
//}
