package lotto.view;

public class UserPrompt {

    public static String promptPurchase() {
        Output.printMessage("구입 금액을 입력해 주세요.");
        return Input.takeInput();
    }

    public static String promptNumberOfManual() {
        Output.printMessage("수동으로 구입할 로또 수를 입력해 주세요.");
        return Input.takeInput();
    }

    public static String promptManual() {
        Output.printMessage("수동으로 로또를 입력해 주세요.");
        return Input.takeInput();
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