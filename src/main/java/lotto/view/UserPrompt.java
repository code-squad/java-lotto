package lotto.view;

import lotto.domain.utils.Parser;

public class UserPrompt {

    public static String promptPurchase() {
        Output.printMessage("구입 금액을 입력해 주세요.");
        return Input.takeInput();
    }

    public static String promptNumberOfManual() {
        Output.printMessage("수동으로 구입할 로또 수를 입력해 주세요.");
        return Input.takeInput();
    }

    public static String promptManual(String number) {
        StringBuilder builder = new StringBuilder();
        int manual = Parser.parseToInt(number); //throws exception
        Output.printMessage("수동으로 로또를 입력해 주세요.");
        for (int i = 0; i < manual; i++) {
            builder.append(Input.takeInput()).append("\n");
        }
        return builder.toString();
    }

    public static String promptWinningNumbers() {
        Output.printMessage("지난 주 당첨 번호를 입력해 주세요.");
        return Input.takeInput();
    }

    public static String promptBonusNumber() {
        Output.printMessage("보너스 볼을 입력해 주세요.");
        return Input.takeInput();
    }
}