package input;

import java.util.Scanner;

public class InputMoney {
    public static Integer inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int inputMoney = scanner.nextInt();
        return inputMoney;
    }
}
