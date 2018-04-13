package LottoGame.view;

import java.util.Scanner;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class ConsoleInputView {

    public static int getMoney(Scanner sc) {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static int getManualLottoCount(Scanner sc) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static String getManualLottoNumber(Scanner sc) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static String getWinningNumber(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String text = sc.nextLine();
        return text;
    }

    public static int getBonusNumber(Scanner sc) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

}