package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class UserPrompt {
    public static final int LOTTO_PRICE = 1000;

    public static int getTotalNumberOfTickets() {
        try {
            return promptNumberOfTickets();
        } catch (IllegalArgumentException e) {
            return getTotalNumberOfTickets();
        }
    }

    private static int promptNumberOfTickets() throws IllegalArgumentException {
        Output.printMessage("구입 금액을 입력해 주세요.");
        int money = Parser.parseToInt(Input.takeInput());
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상으로 입력해주세요.");
        }
        return money / LOTTO_PRICE;
    }

    public static int getNumberOfManual(int total) {
        try {
            return promptNumberOfManual(total);
        } catch (IllegalArgumentException e) {
            return getNumberOfManual(total);
        }
    }

    private static int promptNumberOfManual(int total) throws IllegalArgumentException {
        Output.printMessage("수동으로 구입할 로또 수를 입력해 주세요.");
        int manual = Parser.parseToInt(Input.takeInput());
        if (manual > total) {
            throw new IllegalArgumentException("총 로또 수보다 많습니다.");
        }
        if (manual <= 0) {
            return 0;
        }
        return manual;
    }

    public static List<List<Integer>> getManual() {
        try {
            String input = promptManual();
            return Parser.parseToLottoFormat(input);
        } catch (IllegalArgumentException e) {
            return getManual();
        }
    }

    private static String promptManual() {
        Output.printMessage("수동으로 구매할 번호를 각각 새 줄에 입력해 주세요.");
        return Input.takeInput();
    }

    public static List<Integer> getWinningNumbers() {
        try {
            return promptWinningNumbers();
        } catch (IllegalArgumentException e) {
            return getWinningNumbers();
        }
    }

    private static List<Integer> promptWinningNumbers() throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();

        Output.printMessage("지난 주 당첨 번호를 입력해 주세요.");
        List<String> input = Parser.splitToLottoStrings(Input.takeInput());
        if (input.size() != 1) {
            throw new IllegalArgumentException("당첨 로또 하나만 입력해 주세요.");
        }
        for (String num : input) {
            numbers = Parser.parseToIntegers(Parser.splitToNumberStrings(num));
        }
        return numbers;
    }

    public static int getBonusNumber() { //중복 체크
        try {
            return promptBonusNumber();
        } catch (IllegalArgumentException e) {
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