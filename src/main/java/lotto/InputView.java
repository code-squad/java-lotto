package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int inputMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        int inputMoney = scanner.nextInt();
        scanner.nextLine();
        return inputMoney;
    }

    public static List<Integer> inputMyLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력 해주세요.");
        String[] inputNumber = scanner.nextLine().split(",\\s*");
        List<Integer> result = Arrays.asList(inputNumber).stream().map(s -> Integer.parseInt(s))
                       .collect(Collectors.toList());
        return result;
    }
}
