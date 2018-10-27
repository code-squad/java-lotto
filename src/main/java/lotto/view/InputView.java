package lotto.view;

import lotto.dto.InputDto;

import java.util.Scanner;

public class InputView {

    public static InputDto getInputData() {
        int money = buyLotto();
        int numberOfLottoToBuyManually = enterNumberOfLottoToBuyManully();
        String[] enterNumbers = enterNumbersOfLottoToBuyManully(numberOfLottoToBuyManually);
        return new InputDto(money, numberOfLottoToBuyManually, enterNumbers);
    }

    private static int buyLotto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return checkBuyMoney(checkInputTypeOfInteger(sc));
    }

    private static int checkBuyMoney(int money) {
        if (money < 1000) {
            throw new BelowLimitMoneyException("구입 금액은 1,000원 이상입니다.");
        }
        return money;
    }

    private static int enterNumberOfLottoToBuyManully() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return checkInputTypeOfInteger(sc);
    }

    private static String[] enterNumbersOfLottoToBuyManully(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String[] numbers = new String[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = sc.next();
        }
        return numbers;
    }

    private static int checkInputTypeOfInteger(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new InputTypeException("숫자로 입력해주세요, 처음으로 돌아갑니다.");
        }
        return scanner.nextInt();
    }

    public static String getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).next();
    }

    public static int getWinningBonusNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
