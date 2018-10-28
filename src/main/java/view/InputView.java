package view;

import util.Utility;

import java.util.*;

public class InputView {
    private static Scanner scan = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Utility.divideThousand(scan.nextInt());
    }

    public static String[] intputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scan.nextLine();
        return Utility.splitComma(Utility.blankRemove(scan.nextLine()));
    }
}
