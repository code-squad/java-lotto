package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView implements View {

    private static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }

    public static int getAmount() throws IllegalArgumentException, NoSuchElementException, IllegalStateException {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> getWinningNumber() throws IllegalArgumentException, NoSuchElementException, IllegalStateException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumberWithComma = scanner.next();

        String[] splitNumber = inputNumberWithComma.split(",");

        return Arrays.asList(splitNumber);
    }

    public static String getBonusNumber() throws IllegalArgumentException, NoSuchElementException, IllegalStateException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.next();
    }
}
