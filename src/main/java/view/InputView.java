package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int input() {
        System.out.println("로또를 구매할 금액을 입력해 주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int lottoSize(int input) {
        if (input / 1000 == 0) {
            throw new IllegalArgumentException("돈이 없어서 구매할 수가 없습니다.");
        }
        return input / 1000;
    }

    public static List<String> winnigLotto() {
        System.out.println("\n당첨 로또를 입력해 주세요");
        List<String> lotto = new ArrayList<>(Arrays.asList(scanner.nextLine().replace(" ", "").split(",")));
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("로또 번호 개수가 6개가 아닙니다.");
        }
        return lotto;
    }

    public static List<String> manualLotto() {
        List<String> lotto = new ArrayList<>(Arrays.asList(scanner.nextLine().replace(" ", "").split(",")));
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("로또 번호 개수가 6개가 아닙니다.");
        }
        return lotto;
    }

    public static int manualCount(int count) {
        System.out.println("수동으로 구매할 로또의 숫자를 입력해 주세요");
        int maualCount = Integer.parseInt(scanner.nextLine());
        if (count < maualCount) {
            throw new IllegalArgumentException("돈이 없어 구매할 수 없습니다.");
        }
        return maualCount;
    }


    public static int bonusLotto() {
        System.out.println("보너스 로또를 입력해 주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> separatorComa(String winnerLotto) {
        return Arrays.asList(winnerLotto.split(","));
    }
}
