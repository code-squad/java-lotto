package view;

import domain.WinningNumbers;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해주세요");

        int amount = scanner.nextInt();
        scanner.nextLine();

        if (amount < 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다");
        }
        return amount;
    }

    public static WinningNumbers getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");

        String input = scanner.nextLine();
        return new WinningNumbers(toIntArray(removeWhiteSpace(splitInput(input))));
    }

    private static String[] removeWhiteSpace(String[] inputs) {
        return Arrays.stream(inputs)
                     .map(String::trim)
                     .toArray(String[]::new);
    }

    private static int[] toIntArray(String[] inputs) {
        return Arrays.stream(inputs)
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    private static String[] splitInput(String input) {
        return StringUtils.split(input, ',');
    }

}
