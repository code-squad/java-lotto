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
        List<Integer> normalNumbers = null;
        int bonusNumber = -1;
        try {
            normalNumbers = getNormalNumbers();
            bonusNumber = getBonusNumbers(normalNumbers);
        } catch (IllegalArgumentException e) {
            return getWinningNumber();
        }
        return new WinningLotto(new Lotto(normalNumbers), bonusNumber);
    }

    private static List<Integer> getNormalNumbers() throws IllegalArgumentException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumberMessage = splitNumberMessage(scanner.nextLine());
        checkDuplicateInput(splitNumberMessage);
        for (String numberMessage : splitNumberMessage) {
            numbers.add(convertToNumber(numberMessage));
        }
        return numbers;
    }

    private static int getBonusNumbers(List<Integer> normalNumber) throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = convertToNumber(scanner.nextLine());
        checkDuplicateInput(normalNumber, bonusNumber);
        return bonusNumber;
    }

    private static void checkDuplicateInput(List<Integer> normalNumber, int bonusNumber) throws IllegalArgumentException {
        if (normalNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스번호가 중복되었습니다.");
        }
    }

    private static void checkDuplicateInput(String[] numbersMessage) throws IllegalArgumentException {
        Set<String> checkMachine = new HashSet<>(Arrays.asList(numbersMessage));
        if (checkMachine.size() != numbersMessage.length) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    private static String[] splitNumberMessage(String inputNumbers) {
        return inputNumbers.split(",\\s*");
    }
}
