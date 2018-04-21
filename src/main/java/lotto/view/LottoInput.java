package lotto.view;

import java.util.Scanner;

public class LottoInput {

    public String input() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int startLotto() {
        String times = input();
        return Integer.valueOf(times);
    }

    public String[] inputLastWeekNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.replaceAll(" ", "").split(",");
    }

    public int inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Integer.valueOf(scanner.nextLine());
    }

}
