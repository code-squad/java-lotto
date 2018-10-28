package view;

import java.util.Scanner;

import static view.ResultView.NEWLINE;

public class InputView {
    private static Scanner scan = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scan.nextLine());
    }

    public static int inputManualLottoCount() {
        System.out.println(NEWLINE + "수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scan.nextLine());
    }

    public static String inputManualLottoNum() {
        return scan.nextLine();
    }

    public static String inputWinningLottoNum() {
        System.out.println(NEWLINE + "지난 주 당첨 번호를 입력해 주세요.");
        return scan.nextLine();
    }

    public static int inputBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scan.nextLine());
    }

}
