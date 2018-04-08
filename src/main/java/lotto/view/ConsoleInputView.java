package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;

public class ConsoleInputView {
    private static final String BUY_ORDER_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ORDER_RESULT_MESSAGE_FORMAT = "%s개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private ConsoleInputView() {}

    public static void printBuyOrderMessage() {
        System.out.println(BUY_ORDER_MESSAGE);
    }

    public static void printOrderResult(List<LottoTicket> buyTickets) {
        System.out.println(String.format(ORDER_RESULT_MESSAGE_FORMAT, buyTickets.size()));
        buyTickets.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningNumbersMessage() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }
}
