package view;

import domain.Lotto;
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

    public static Lotto getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningNumber = null;
        try {
            winningNumber = buildWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumber = getWinningNumber();
        }
        return winningNumber;
    }

    private static Lotto buildWinningNumber() throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        String[] numbersMessage = splitNumberMessage(scanner.nextLine());
        if (isDuplicateInput(numbersMessage)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }

        for (String numberMessage : numbersMessage) {
            numbers.add(convertMessageToNum(numberMessage));
        }
        return new Lotto(numbers);
    }

    private static boolean isDuplicateInput(String[] numbersMessage) {
        Set<String> checkMachine = new HashSet<>(Arrays.asList(numbersMessage));
        return checkMachine.size() != numbersMessage.length;
    }

    private static String[] splitNumberMessage(String inputNumbers) {
        return inputNumbers.split(",\\s*");
    }

    private static int convertMessageToNum(String numberMessage) throws IllegalArgumentException {
        try {
            return Integer.parseInt(numberMessage);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("문자가 포함되어 있습니다.");
        }
    }
}
