package Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputLottoView {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return checkInputMoney(scanner.nextInt());
    }해

    public static int checkInputMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException();
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return money;
    }

    public static List<String> inputWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return stringToList(scanner.nextLine());
    }

    public static int inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        return checkBonusNumber(scanner.nextInt());
    }

    public static int checkBonusNumber(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException();
        }
        return bonus;
    }

    private static List<String> stringToList(String winnerNumber) {
        return split(winnerNumber);
    }

    private static List<String> split(String winnerNumber) {
        return Arrays.asList(trim(winnerNumber.split(",")));
    }

    private static String[] trim(String[] winnerNumbers) {
        for (String winnerNumber : winnerNumbers) {
            winnerNumber.trim();
        }
        return winnerNumbers;
    }

}