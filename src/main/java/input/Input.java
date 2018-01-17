package input;

import java.util.Scanner;

public class Input {
    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public String inputLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
