package view;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static int purchasePrice() {
        System.out.println("구입금액을 입력하세요");
        return sc.nextInt();
    }

    public static int inputBonus(){
        System.out.println("보너스 볼을 입력 해 주세요");
        return sc.nextInt();
    }

    public static String WinnerLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc.nextLine();
        return sc.nextLine();
    }
}
