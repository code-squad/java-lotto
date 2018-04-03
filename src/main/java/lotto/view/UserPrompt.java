package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Parser;
import lotto.domain.WinningLotto;

import java.util.List;

public class UserPrompt {
    private static final int LOTTO_PRICE = 1000;

    public static Lotto promptUserForPurchase() {

        int total = getNumberOfTickets();
        int manual = getNumberOfManual(total);

        return new Lotto(ticketsBought);

    }

    private static int getNumberOfTickets() {
        try {
            return promptNumberOfTickets();
        } catch (IllegalArgumentException e) {
            return getNumberOfTickets();
        }
    }

    private static int promptNumberOfTickets() throws IllegalArgumentException {
        Output.printMessage("구입 금액을 입력해 주세요.");
        int money = Parser.parseToInt(Input.takeInput());
        if (money < LOTTO_PRICE) {
            Output.printMessage("1000원 이상으로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return money / LOTTO_PRICE;
    }

    private static int getNumberOfManual(int total) {
        try {
            return promptNumberOfManual(total);
        } catch (IllegalArgumentException e) {
            return getNumberOfManual(total);
        }
    }

    private static int promptNumberOfManual(int total) throws IllegalArgumentException {
        Output.printMessage("수동으로 구입할 로또 수를 입력해 주세요.");
        int manual = Parser.parseToInt(Input.takeInput());
        if (manual > total || manual < 0) {
            throw new IllegalArgumentException();
        }
        return manual;
    }

    public static WinningLotto promptUserForWinningNumbers() {
        try {
            Output.printMessage("지난 주 당첨 번호를 입력해 주세요.");
            List<Number> winningNumbers = Parser.parseToNumberArray(Parser.splitString(Input.takeInput()));

            Output.printMessage("보너스 볼을 입력해 주세요.");
            Number bonusNumber = Parser.parseToNumber(Parser.parseToInt(Input.takeInput()));

            WinningLotto.checkDuplicate(winningNumbers, bonusNumber);
            return new WinningLotto(winningNumbers, bonusNumber);

        } catch (IllegalArgumentException e) {
            return promptUserForWinningNumbers();
        }
    }
}
