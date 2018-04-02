package View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final int TICKET_PRICE = 1000;
    private static Scanner scanner;

    public static int getPurchaseFee() {
        scanner = new Scanner(System.in);
        System.out.println("구매금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public static int getTicketCount(int purchaseFee) {
        int count = purchaseFee / TICKET_PRICE;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }


    public static List getWinningNumber() {
        // "1, 2, 3, 4, 5, 6"
        scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] numbers = scanner.nextLine().split(", ");
        System.out.println(Arrays.toString(numbers));
        return parseInt(numbers);
    }

    private static List parseInt(String[] userInput) {
        Integer[] numbers = new Integer[userInput.length];
        int i = 0;
        for (String number : userInput) {
            numbers[i] = Integer.parseInt(number);
            i++;
        }
        return Arrays.asList(numbers);
    }
}
