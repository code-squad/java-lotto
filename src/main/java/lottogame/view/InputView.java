package lottogame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static List<Integer> getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(sc.next().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
