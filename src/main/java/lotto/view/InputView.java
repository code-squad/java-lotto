package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int getWon() {
        System.out.println("구입금액을 입력해주세요");
        return getNextInt();
    }

    public static List<Integer> getLucyNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String[] numbers = getNextLine().split(", ");

        List<Integer> luckyNumbers = new ArrayList<>();
        for (String number : numbers) {
            luckyNumbers.add(Integer.parseInt(number));
        }

        return luckyNumbers;
    }

    private static int getNextInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String getNextLine() {
        return new Scanner(System.in).nextLine();
    }
}
