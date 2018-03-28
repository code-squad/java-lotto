package view;

import domain.Lotto;
import domain.WinningLotto;
import utils.LottoMachine;

import java.util.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = 0;
        try {
            amount = buildPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            amount = getPurchaseAmount();
        }
        System.out.println(amount + "개를 구매하였습니다.");
        return amount;
    }

    private static int buildPurchaseAmount() throws IllegalArgumentException {
        int money = convertToNumber(scanner.nextLine());
        int amount = LottoMachine.calcQuantity(money);
        if (LottoMachine.isImPossibleBuy(amount)) {
            throw new IllegalArgumentException("돈이 부족하여 구매할 수 없습니다.");
        }
        return amount;
    }

    private static int convertToNumber(String numberMessage) throws IllegalArgumentException {
        try {
            return Integer.parseInt(numberMessage);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
    }

    public static WinningLotto getWinningNumber() {
        Lotto lotto = null;
        try {
            lotto = new Lotto(buildNormalNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getWinningNumber();
        }
        int bonusNumber = buildBonusNumber(lotto);
        return new WinningLotto(lotto, bonusNumber);
    }

    private static List<Integer> buildNormalNumbers() {
        List<Integer> numbers = null;
        try {
            numbers = getNormalNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buildNormalNumbers();
        }
        return numbers;
    }

    private static List<Integer> getNormalNumbers() throws IllegalArgumentException {
        System.out.println("당첨번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        String[] numbersMessage = splitNumberMessage(scanner.nextLine());
        if (checkDuplicateInput(numbersMessage)) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
        addNumbers(numbers, numbersMessage);
        return numbers;
    }

    private static String[] splitNumberMessage(String inputNumbers) {
        return inputNumbers.split(",\\s*");
    }

    private static boolean checkDuplicateInput(String[] numbersMessage) {
        Set<String> checkMachine = new HashSet<>(Arrays.asList(numbersMessage));
        return checkMachine.size() != numbersMessage.length;
    }

    private static void addNumbers(List<Integer> numbers, String[] numbersMessage) throws IllegalArgumentException {
        for (String number : numbersMessage) {
            numbers.add(convertToNumber(number));
        }
    }

    private static int buildBonusNumber(Lotto lotto) {
        int bonusNumber = -1;
        try {
            bonusNumber = getBonusNumbers(lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buildBonusNumber(lotto);
        }
        return bonusNumber;
    }

    private static int getBonusNumbers(Lotto lotto) throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = convertToNumber(scanner.nextLine());
        if (lotto.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호로 지정된 번호입니다.");
        }

        if (Lotto.isOutRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException("범위를 벗어난 숫자입니다.");
        }
        return bonusNumber;
    }
}
