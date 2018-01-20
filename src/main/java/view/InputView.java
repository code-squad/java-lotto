package view;

import domain.Lotto;
import domain.LottoNumber;
import domain.Lottos;
import domain.WinningNumbers;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static common.Constant.LOTTO_PRICE;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해주세요");

        int amount = scanner.nextInt();
        scanner.nextLine();

        if (amount < 1000) {
            throw new IllegalArgumentException("구매 금액은 1000보다 크거나 같아야 합니다");
        }
        return amount;
    }

    public static Optional<Lottos> getManualLottos(int purchaseAmount) {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요");
        int count = scanner.nextInt();
        scanner.nextLine();
        checkInput(count, purchaseAmount);
        System.out.println("수동으로 구매할 번호를 입력해주세요");

        if (count == 0) {
            return Optional.empty();
        }
        return Optional.of(new Lottos(IntStream.range(0, count)
                                               .mapToObj(i -> getManualLotto())
                                               .collect(Collectors.toList())));
    }

    public static WinningNumbers getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        String input = scanner.nextLine();
        System.out.println("보너스 볼을 입력해주세요");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();

        return new WinningNumbers(new Lotto(toIntArray(removeWhiteSpace(splitInput(input)))), new LottoNumber(bonusNumber));
    }

    private static void checkInput(int count, int purchaseAmount) {
        if (count * LOTTO_PRICE > purchaseAmount) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] removeWhiteSpace(String[] inputs) {
        return Arrays.stream(inputs)
                     .map(String::trim)
                     .toArray(String[]::new);
    }

    public static int[] toIntArray(String[] inputs) {
        return Arrays.stream(inputs)
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    public static String[] splitInput(String input) {
        return StringUtils.split(input, ',');
    }

    public static Lotto getManualLotto() {
        return new Lotto(getManualLottoNumber());
    }

    private static int[] getManualLottoNumber() {
        String input = scanner.nextLine();
        return toIntArray(removeWhiteSpace(splitInput(input)));
    }
}
