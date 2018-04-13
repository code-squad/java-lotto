package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.PrizeDivision;

import java.util.Map;

public class ConsoleOutputView {
    private static final String ORDER_RESULT_MESSAGE_FORMAT = "수동으로 %s장, 자동으로 %s장을 구매했습니다.";
    private static final String PRIZE_DIVISION_RESULT_FORMAT = "%s (%s원): %s개";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.0f%%입니다.";

    private ConsoleOutputView() { }

    public static void getPayResult(LottoTickets lottoTickets) {
        System.out.println(String.format(ORDER_RESULT_MESSAGE_FORMAT,
                lottoTickets.getSelfCount(), lottoTickets.getAutoCount()));
        lottoTickets.getAllTickets().forEach(System.out::println);
        System.out.println();
    }

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
