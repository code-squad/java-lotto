package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static int getWon() {
        System.out.println("구입금액을 입력해주세요");
        return getNextInt();
    }

    public static int getBuyLottoCount() {
        System.out.println("수동 구매할 로또 수를 입력해 주세요");
        return getNextInt();
    }

    public static List<String> getBuyLottoNumber(int buyCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        String[] lottoNumbers = new String[buyCount];
        for (int i = 0; i < buyCount; i++) {
            lottoNumbers[i] = getNextLine();
        }

        return Arrays.stream(lottoNumbers).collect(Collectors.toList());
    }

    public static List<Integer> getLucyNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String[] numbers = getNextLine().split(", ");

        List<Integer> luckyNumbers = new ArrayList<>();
        for (String number : numbers) {
            luckyNumbers.add(Integer.parseInt(number));
        }

        return luckyNumbers;
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return getNextInt();
    }

    private static int getNextInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String getNextLine() {
        return new Scanner(System.in).nextLine();
    }
}
