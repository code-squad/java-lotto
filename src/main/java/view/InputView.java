package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int input() {
        System.out.println("자동을 구매할 금액을 입력해 주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int lottoSize(int input) {
        return input / 1000;
    }

    public static List<String> lotto() {
        System.out.println("\n당첨 로또를 입력해 주세요");
        List<String> lotto = new ArrayList<>(Arrays.asList(scanner.nextLine().replace(" ", "").split(",")));
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("로또 번호 개수가 6개가 아닙니다.");
        }
        return lotto;
    }

    public static List<String> separatorComa(String winnerLotto) {
        return Arrays.asList(winnerLotto.split(","));
    }
}
