package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    public static int purchasePrice(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String winningNumber(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public static int bonusBall(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
<<<<<<< HEAD

    public static int manualCount(Scanner scanner) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> manualLottoNumbs(int manualNumber) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<String> manualLotto = new ArrayList<>();
        for (int i = 0; i < manualNumber; i++) {
            String str = scanner.nextLine();
            manualLotto.add(str);
        }
        return manualLotto;
    }
=======
>>>>>>> JosephChun
}
