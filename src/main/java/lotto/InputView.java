package lotto;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int inputMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        return scanner.nextInt();
    }
}
