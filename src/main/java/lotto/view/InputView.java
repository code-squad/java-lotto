package lotto.view;

import java.util.Scanner;

public class InputView {

    private static Scanner s = new Scanner(System.in);

    public static int money() {
        System.out.println("구입 금액을 입력해 주세요.");
        return s.nextInt();
    }

    public static String prizeNum() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return s.next();
    }

    public static int manualNum(){
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return s.nextInt();
    }

    public static void manualMessage(){
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static String manualLottoNum(){
        return s.next();
    }

    public static int bonusNum() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        return s.nextInt();
    }
}
