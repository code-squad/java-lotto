package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scan = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scan.nextInt();
    }


    public static String inputWinningLottoNum() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scan.nextLine();
        return scan.nextLine();
    }
}
