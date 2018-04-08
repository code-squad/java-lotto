package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author sangsik.kim
 */
public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.next().split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}
