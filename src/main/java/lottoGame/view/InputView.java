package lottoGame.view;

import java.util.Scanner;

public class InputView {
    private static  Scanner scanner = new Scanner(System.in);

    public static int priceInput() {
        System.out.println("구입금액을 입력해주세요.");

        return scanner.nextInt();
    }

    public static String lastWeekNums() {
        System.out.println("지난주 당첨 번호를 입력해주세요");

        return scanner.next();
    }
}
