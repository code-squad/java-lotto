package lotto.view;

import lotto.domain.Number;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;

import java.util.List;

import static lotto.view.Parser.*;

public class UserPrompt {
    public static final int LOTTO_PRICE = 1000;

    public static List<Ticket> getUserTickets() {
        int total = getTotalNumberOfTickets();
        int manual = getNumberOfManual(total);

        List<Ticket> manualTickets = TicketGenerator.generateManualTicket(manual);
        List<Ticket> autoTickets = TicketGenerator.generateAutoTicket(total - manual);
        manualTickets.addAll(autoTickets);

        return manualTickets;
    }

    private static int getTotalNumberOfTickets() {
        try {
            return promptNumberOfTickets();
        } catch (IllegalArgumentException e) {
            return getTotalNumberOfTickets();
        }
    }

    private static int promptNumberOfTickets() throws IllegalArgumentException {
        Output.printMessage("구입 금액을 입력해 주세요.");
        int money = parseToInt(Input.takeInput());
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
        int manual = parseToInt(Input.takeInput());
        if (manual > total) {
            Output.printMessage("총 로또 수보다 많습니다.");
            throw new IllegalArgumentException();
        }
        if (manual <= 0) {
            return 0;
        }
        return manual;
    }

    public static Ticket getWinningTicket() {
        return TicketGenerator.generateWinningTicket(getWinningNumbers());
    }

    private static String[] getWinningNumbers() {
        try {
            Output.printMessage("지난 주 당첨 번호를 입력해 주세요.");
            return splitString(Input.takeInput());
        } catch (IllegalArgumentException e) {
            return getWinningNumbers();
        }
    }

    public static Number getBonusNumber(Ticket winningTicket) {
        try {
            return getNumber(winningTicket);
        } catch (IllegalArgumentException e) {
            return getBonusNumber(winningTicket);
        }
    }

    private static Number getNumber(Ticket winningTicket) {
        Output.printMessage("보너스 볼을 입력해 주세요.");
        String input = Input.takeInput();
        if (input.split(",\\s*").length != 1) {
            Output.printMessage("하나의 숫자만 입력해 주세요.");
            throw new IllegalArgumentException();
        }

        Number bonusNumber = TicketGenerator.generateBonusNumber(parseToInt(input));
        if (WinningLotto.isDuplicate(winningTicket, bonusNumber)) {
            Output.printMessage("보너스 볼이 중복된 숫자 입니다.");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }
}