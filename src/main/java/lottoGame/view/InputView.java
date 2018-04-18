package lottoGame.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scannner = new Scanner(System.in);

    public static int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scannner.nextInt();
    }

    public static String getWinningNumberString() {
        System.out.println("지난 주 당첨금액을 입력해주세요.");
        return scannner.next();
    }
}
