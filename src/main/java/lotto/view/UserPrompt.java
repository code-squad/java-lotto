package lotto.view;

import java.util.List;

public class UserPrompt {
    public static final int LOTTO_PRICE = 1000;
    private static final int MIN = 0;
    private static final int MIN_SIZE = 1;

    public static int getMoney() {
        try {
            return promptPurchase();
        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return getMoney();
        }
    }

    private static int promptPurchase() throws IllegalArgumentException {
        Output.printMessage("구입 금액을 입력해 주세요.");
        int money = Parser.parseToInt(Input.takeInput());
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상으로 입력해주세요.");
        }
        return money;
    }

    public static int getNumberOfManual(int total) {
        try {
            return promptNumberOfManual(total);
        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return getNumberOfManual(total);
        }
    }

    private static int promptNumberOfManual(int total) throws IllegalArgumentException {
        Output.printMessage("수동으로 구입할 로또 수를 입력해 주세요.");
        int manual = Parser.parseToInt(Input.takeInput());
        if (manual > total) {
            throw new IllegalArgumentException("총 로또 수보다 많습니다.");
        }
        if (manual <= MIN) {
            return MIN;
        }
        return manual;
    }

    public static List<List<Integer>> getManual(int manual) {
        try {
            String input = promptManual(manual);
            return Parser.parseToLottoFormat(input);
        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return getManual(manual);
        }
    }

    private static String promptManual(int manual) { //예외 던지기
        String[] numbers = new String[manual];
        Output.printMessage("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manual; i++) {
            numbers[i] = Input.takeInput();
        }
        return String.join("\n", numbers);
    }

    public static List<Integer> getWinningNumbers() {
        try {
            return promptWinningNumbers();
        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private static List<Integer> promptWinningNumbers() throws IllegalArgumentException {
        Output.printMessage("지난 주 당첨 번호를 입력해 주세요.");
        List<List<Integer>> numbers = Parser.parseToLottoFormat(Input.takeInput());
        if (numbers.size() != MIN_SIZE) {
            throw new IllegalArgumentException("당첨 로또 하나만 입력해 주세요.");
        }
        return numbers.get(0);
    }

    public static int getBonusNumber() { //중복 체크
        try {
            return promptBonusNumber();
        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return getBonusNumber();
        }
    }

    private static int promptBonusNumber() throws IllegalArgumentException {
        Output.printMessage("보너스 볼을 입력해 주세요.");
        String input = Input.takeInput();
        if (input.split(",\\s*").length != 1) {
            throw new IllegalArgumentException("하나의 숫자만 입력해 주세요.");
        }
        return Parser.parseToInt(input);
    }
}