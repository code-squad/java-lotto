package lotto.view;

import lotto.domain.PrizeDivision;

import java.util.Map;

public class ConsoleOutputView {
    private static final String PRIZE_DIVISION_RESULT_FORMAT = "%s개 일치 (%s원): %s개";

    private ConsoleOutputView() { }

    public static void printResult(Map<PrizeDivision, Integer> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        result.forEach((k, v) -> 
                System.out.println(String.format(PRIZE_DIVISION_RESULT_FORMAT,
                k.getMatchedNumber(), k.getPrize(), v))
        );
    }
}
