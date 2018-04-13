package lotto.view;

import java.util.Scanner;

public class ConsoleInputView {
    private static final String BUY_ORDER_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String SELF_SELECT_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String SELF_SELECT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
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

    public static int getSelfSelectLottoCount() {
        System.out.println(SELF_SELECT_LOTTO_COUNT_MESSAGE);
        int count = scanner.nextInt();
        scanner.nextLine();

        return count;
    }

    public static void printInputSelfNumbersMessage() {
        System.out.println(SELF_SELECT_MESSAGE);
    }

    public static String getLottoNumbers() {
        return scanner.nextLine();
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
