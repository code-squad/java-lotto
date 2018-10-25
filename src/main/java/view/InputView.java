package view;

import util.Utility;

import java.util.*;

public class InputView {
    private static Scanner scan = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Utility.fromStringToInteger(scan.next()) / 1000;
    }

    public static String[] intputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        scan.nextLine();
        String[] winningNumbers = Utility.splitComma(Utility.blankRemove(scan.nextLine()));
        return winningNumbers;
    }

}
