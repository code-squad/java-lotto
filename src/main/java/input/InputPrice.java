package input;

import java.util.Scanner;

public class InputPrice {
    public static Integer inputPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구매금액을 입력해주세요.");
        return scanner.nextInt();
    }
}
