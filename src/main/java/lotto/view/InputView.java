package lotto.view;

import java.util.Scanner;

public class InputView {
    public static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static String lastWeekWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine().trim().replace(" ", "");
    }

    public static int bonusBall(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    // 수동 로또
    public static int buyManualLottoCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static String manualLotto(){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine().trim().replace(" ", "");
    }
}
