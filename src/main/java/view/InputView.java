package view;

import domain.Lotto;
import domain.WinningLotto;
import utils.LottoMachine;
import utils.MoneyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getBuyAmount() {
        System.out.println("구입금액을 입력해주세요.");
        try {
            int money = convertNumber(scanner.nextLine());
            int amount = MoneyUtils.calcBuyAmount(money);
            System.out.println(amount + "개를 구매하였습니다.");
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBuyAmount();
        }
    }

    public static int convertNumber(String numberMessage) {
        try {
            return Integer.parseInt(numberMessage);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력해야합니다.");
        }
    }

    public static List<Integer> convertNumber(String[] numberMessage) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        for (String number : numberMessage) {
            numbers.add(convertNumber(number));
        }
        return numbers;
    }

    public static WinningLotto getWinningLotto() {
        try {
            Lotto lotto = getLottoNumbers();
            int bonusNumber = getBonusNumber();
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private static Lotto getLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            return LottoMachine.manualBuy(convertNumber(parseLottoNumbers(scanner.nextLine())));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoNumbers();
        }
    }

    public static String[] parseLottoNumbers(String lottoNumbers) {
        return lottoNumbers.split(",\\s*");
    }

    private static int getBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return convertNumber(scanner.nextLine());
    }
}
