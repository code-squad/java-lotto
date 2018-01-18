package lotto.view;

import java.util.Scanner;

public class InputUI {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputLastWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public static int inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }


}
