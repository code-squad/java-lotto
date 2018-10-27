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
}
