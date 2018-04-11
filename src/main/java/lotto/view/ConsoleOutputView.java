package lotto.view;

import lotto.domain.PrizeDivision;

import java.util.Map;

public class ConsoleOutputView {
    private static final String PRIZE_DIVISION_RESULT_FORMAT = "%s (%s원): %s개";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.0f%%입니다.";

    private ConsoleOutputView() { }

    public static void printResult(Map<PrizeDivision, Integer> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        result.forEach((k, v) -> 
                System.out.println(String.format(PRIZE_DIVISION_RESULT_FORMAT,
                k.getDescription(), k.getPrize(), v))
        );
    }

    public static void printRateOfReturn(float rateOfReturn) {
        System.out.println(String.format(RATE_OF_RETURN_FORMAT, rateOfReturn));
    }
}
