package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputUI {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputLastWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public static int inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputManualLottoNumbers(int manualLottoCount) {

        if (manualLottoCount == 0) {
            return null;
        }
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String manual = scanner.next();
            manualLottos.add(manual);
        }
        return manualLottos;
    }


}
