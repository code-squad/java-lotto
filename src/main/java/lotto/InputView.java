package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Joeylee on 2018-01-14.
 */
public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(Integer.parseInt(sc.nextLine()));
    }

    public static Lotto inputMatchingNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String input = sc.nextLine();
        String[] inputs = input.split(", ");

        return convertLotto(inputs);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    private static Lotto convertLotto(String[] inputs) {
        List<Integer> matchingNumbers = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            matchingNumbers.add(Integer.parseInt(inputs[i]));
        }
        return new Lotto(matchingNumbers);
    }

}
