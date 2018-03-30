package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int putMoney() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("올바른 값을 입력해 주세요.");
            return putMoney();
        }
    }

    public static List<Integer> putAnswer() {
        try {
            String[] temp = scanner.nextLine().split(",");
            return Arrays.stream(temp).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (InputMismatchException e) {
            System.out.println("올바른 값을 입력해 주세요.");
            return putAnswer();
        }
    }

}
