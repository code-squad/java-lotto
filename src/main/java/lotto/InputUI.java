package lotto;

import java.util.Scanner;

public class InputUI {
    private Scanner scanner = new Scanner(System.in);

    public int inputAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String inputLastWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }


}
