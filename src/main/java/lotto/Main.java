package lotto;

import lotto.domain.Parser;
import lotto.view.Input;
import lotto.view.Output;

public class Main {

    public static void main(String[] args) {

    }

    private static int promptUser() {
        int numberOfTickets;
        try {
            Output.printMessage("구입 금액을 입력해주세요.");
            numberOfTickets = Parser.getNumberOfTickets(Parser.parseToInt(Input.takeInput()));
        } catch (IllegalArgumentException e) {
            return promptUser();
        }
        return numberOfTickets;
    }
}
