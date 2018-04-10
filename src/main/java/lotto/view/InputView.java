package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author sangsik.kim
 */
public class InputView {
    private static final String GET_AMOUNT_TEXT = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_LOTTO_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_TEXT = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getAmount() {
        System.out.println(GET_AMOUNT_TEXT);
        return scanner.nextInt();
    }

    public static Lotto getWinningLotto() {
        System.out.println(GET_WINNING_LOTTO_TEXT);
        return new Lotto(Arrays.stream(scanner.next().split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));
    }

    public static Integer getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_TEXT);
        return scanner.nextInt();
    }
}
