package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final int TICKET_PRICE = 1000;
    private static Scanner scanner;

    public static int getPurchaseFee() {
        scanner = new Scanner("10000");
        System.out.println("구매금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public static int getTicketCount(int purchaseFee) {
        int count = purchaseFee / TICKET_PRICE;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public static List<Integer> getWinningNumber() {
        // "1, 2, 3, 4, 5, 6"
        scanner = new Scanner(System.in);
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String[] numbers = scanner.nextLine().split(","); // trim() 유무
//        System.out.println(Arrays.toString(numbers));
        return parseInt(numbers);
    }

    public static Integer getBonusNumber() {
        scanner = new Scanner(System.in);
        System.out.println("\n보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.nextLine();
        return Integer.parseInt(bonusNumber);
    }

    private static List<Integer> parseInt(String[] userInput) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : userInput) {
            int convertedNumber = Integer.parseInt(number);
            numbers.add(convertedNumber);
        }
        return numbers;
    }
}