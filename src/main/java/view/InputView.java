package view;

import domain.Ball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int putUserMoney() {
        try {
            System.out.println("구입할 금액을 넣어주세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return putUserMoney();
        }
    }

    public static int putNumOfTicketToBuy() {
        try {
            System.out.println("구입할 티켓 수량을 넣어주세요..");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return putNumOfTicketToBuy();
        }
    }

    public static Ball putBonusBall() {
        try {
            System.out.println("보너스 볼을 뽑아주세요.");
            return Ball.of(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return putBonusBall();
        }
    }

    public static List<Integer> putWinningLotto() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요. 구분자 (\",\")");
            String[] winningNumbers = scanner.nextLine().split(",");
            return Arrays.stream(winningNumbers).map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
        } catch (RuntimeException e) {
            System.out.println("올바른 값을 입력해 주세요.");
            return putWinningLotto();
        }
    }
}
