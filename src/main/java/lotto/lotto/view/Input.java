package lotto.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {

    private static final int LOTTO = 1000;
    private static final int ZERO = 0;

    public static int inputMoney() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = scan.nextInt();
        return money;
    }

    public static int inputManualNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualNumber = scan.nextInt();
        return manualNumber;
    }

    public static List<String> inputManualLotto(int manualNumber, int money) {
        Scanner scan = new Scanner(System.in);
        manualException(manualNumber, money);
        List<String> manualLotto = new ArrayList<>();
        for (int i = 0; i < manualNumber; i++) {
            String str = scan.nextLine();
            manualLotto.add(str);
        }
        return manualLotto;
    }

    public static String inputWinningNumber() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scan2.nextLine();
    }

    public static int inputBonus() {
        Scanner scan3 = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요");
        int bonus = scan3.nextInt();
        return bonus;
    }

    public static void manualException(int manualNumber, int money) {
        if (manualNumber > 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
        if (manualNumber < ZERO) {
            throw new IllegalArgumentException("0이상의 수만 입력할 수 있습니다.");
        }
        if (manualNumber > money / LOTTO) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
    }
}
