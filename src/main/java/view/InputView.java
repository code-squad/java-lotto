package view;

import util.Utility;

import java.util.*;

public class InputView {
    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Utility.divideThousand(new Scanner(System.in).nextInt());
    }

    public static int inputBonusBall(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static String[] intputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Utility.splitComma(Utility.blankRemove(new Scanner(System.in).nextLine()));
    }
}
