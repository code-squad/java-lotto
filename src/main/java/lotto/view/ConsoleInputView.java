package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputView {
    private static final String BUY_ORDER_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ORDER_RESULT_MESSAGE_FORMAT = "%s개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    
    private static final Scanner scanner = new Scanner(System.in, "UTF-8");

    private ConsoleInputView() {}

    public static int getPay() {
        System.out.println(BUY_ORDER_MESSAGE);
        int pay = scanner.nextInt();
        scanner.nextLine();
        
        return pay;
    }

    public static void getPayResult(List<LottoTicket> buyTickets) {
        System.out.println(String.format(ORDER_RESULT_MESSAGE_FORMAT, buyTickets.size()));
        buyTickets.forEach(System.out::println);
        System.out.println();
    }

    public static String getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }
    
    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
