package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PURCHASE_AMOUNT_FORMAT = "구입금액을 입력해 주세요.";
    private static final String LAST_PRIZE_OF_NUMBER_FORMAT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_FORMAT = "보너스 볼을 입력해 주세요.";

    public static int initPurchasePrice() {
        println(PURCHASE_AMOUNT_FORMAT);
        return new Scanner(System.in).nextInt();
    }

    public static List<Integer> initLastPrizeOfNumber() {
        println(LAST_PRIZE_OF_NUMBER_FORMAT);
        return parseString().stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static List<String> parseString() {
        return Arrays.stream(new Scanner(System.in).nextLine().split(",", -1)).map(String::trim).collect(Collectors.toList());
    }

    private static void println(String input) {
        System.out.println(input);
    }

    public static int initBonusNumber() {
        System.out.println(BONUS_BALL_FORMAT);
        return new Scanner(System.in).nextInt();
    }
}
