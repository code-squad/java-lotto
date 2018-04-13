package lotto;

import java.util.Scanner;

public class LottoInput {

    public static String input() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int startLotto() {
        String times = input();
        return Integer.valueOf(times);
    }

    public static String[] inputLastWeekNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.replaceAll(" ", "").split(",");
    }

}
