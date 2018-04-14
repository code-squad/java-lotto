package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author sangsik.kim
 */
public class InputView {
    private static final String GET_AMOUNT_TEXT = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_LOTTO_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_TEXT = "보너스 볼을 입력해 주세요.";
    private static final String GET_MANUAL_ORDER_COUNT_TEXT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String GET_MANUAL_ORDER_NUMBERS_TEXT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static Money getAmount() {
        System.out.println(GET_AMOUNT_TEXT);
        return Money.of(scanner.nextLong());
    }

    public static WinningLotto getWinningLotto() {
        return WinningLotto.of(getWinningNumbers(), getBonusNumber());
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println(GET_WINNING_LOTTO_TEXT);
        return convertInputStringToNumberList();
    }

    private static List<Integer> convertInputStringToNumberList() {
        return Arrays.stream(scanner.next().split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private static int getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_TEXT);
        return scanner.nextInt();
    }

    public static int getCustomOrderCount() {
        System.out.println(GET_MANUAL_ORDER_COUNT_TEXT);
        return scanner.nextInt();
    }

    public static List<Lotto> getCustomLottos(int customOrderCount) {
        System.out.println(GET_MANUAL_ORDER_NUMBERS_TEXT);

        List<Lotto> customLottos = new ArrayList();
        for (int i = 0; i < customOrderCount; i++) {
            customLottos.add(Lotto.of(convertInputStringToNumberList()));
        }
        return customLottos;
    }
}
