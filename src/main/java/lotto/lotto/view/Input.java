package lotto.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static int inputMoney() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = scan.nextInt();
        return money;
    }

    public static String inputWinningNumber() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scan2.nextLine();
    }

    public static int inputBonus() {
        Scanner scan = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요");
        int bonus = scan.nextInt();
        return bonus;
    }

}
