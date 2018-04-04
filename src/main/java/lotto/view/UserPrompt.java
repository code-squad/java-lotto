package lotto.view;

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
        int money = WebParser.parseToInt(Input.takeInput());
        if (money < LOTTO_PRICE) {
            Output.printMessage("1000원 이상으로 입력해주세요.");
            throw new IllegalArgumentException();
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

    public static String promptManual(int manual) {
        Output.printMessage("수동으로 구매할 번호를 각각 새 줄에 입력해 주세요.");
        return Input.takeInput();
    }

    private static int promptNumberOfManual(int total) throws IllegalArgumentException {
        Output.printMessage("수동으로 구입할 로또 수를 입력해 주세요.");
        int manual = WebParser.parseToInt(Input.takeInput());
        if (manual > total) {
            Output.printMessage("총 로또 수보다 많습니다.");
            throw new IllegalArgumentException();
        }
        if (manual <= 0) {
            return 0;
        }
        return manual;
    }

    public static String getWinningNumbers() {
        try {
            Output.printMessage("지난 주 당첨 번호를 입력해 주세요.");
            return Input.takeInput();
        } catch (IllegalArgumentException e) {
            return getWinningNumbers();
        }
    }

    public static int getBonusNumber() { //중복 체크
        try {
            Output.printMessage("보너스 볼을 입력해 주세요.");
            return promptBonusNumber();
        } catch (IllegalArgumentException e) {
            return getBonusNumber();
        }
    }

    private static int promptBonusNumber() throws IllegalArgumentException {
        String input = Input.takeInput();
        if (input.split(",\\s*").length != 1) {
            Output.printMessage("하나의 숫자만 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        return WebParser.parseToInt(input);
    }
}