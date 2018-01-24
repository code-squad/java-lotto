package io;

import java.util.Scanner;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static Integer readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = scanner.nextLine();
        return Integer.parseInt(money);
    }

    public static String readWinningNumbers () {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static Integer readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
