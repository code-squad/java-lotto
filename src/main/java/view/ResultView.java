package view;

import domain.User;

import java.util.List;

public class ResultView {

    public static void printLottos(User user) {
        user.getLottos().forEach(i -> print(i.toString()));
    }

    public static void printResult(User larry) {
        List<Integer> prizeStatistics = larry.getPrizeStatistics();
        System.out.println("당첨 통계");
        System.out.println("-------------------------------");
        System.out.println(String.format("3개 일치 : (5000원) - %d개", prizeStatistics.get(4)));
        System.out.println(String.format("4개 일치 : (50000원) - %d개", prizeStatistics.get(3)));
        System.out.println(String.format("5개 일치 : (150000원) - %d개", prizeStatistics.get(2)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치(30000000원)- %d개", prizeStatistics.get(1)));
        System.out.println(String.format("6개 일치 : (2000000000원) - %d개", prizeStatistics.get(0)));
        System.out.println(String.format("총 수익률은 %d%%입니다.", larry.calcProfit()));
    }

    private static void print(String s) {
        System.out.println(s);
    }

}
