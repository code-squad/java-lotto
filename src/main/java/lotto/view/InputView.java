package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static long inputMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        long inputMoney = scanner.nextLong();
        scanner.nextLine();
        System.out.printf("%d개를 구매했습니다.\n", Money.getCountOfPurchasedLotto(inputMoney));
        return inputMoney;
    }

    public static Lotto inputWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력 해주세요.");
        String[] inputNumber = scanner.nextLine().split(",\\s*");
        List<LottoNumber> result = Arrays.asList(inputNumber).stream()
                                     .map(s -> LottoNumber.of(Integer.parseInt(s)))
                                     .collect(Collectors.toList());
        return new Lotto(result);
    }

    public static int inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
