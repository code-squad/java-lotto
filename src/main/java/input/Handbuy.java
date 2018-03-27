package input;

import java.util.Scanner;

public class Handbuy {
    public static Integer handBuy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }
}
