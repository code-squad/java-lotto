package lotto.domain;

import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Parser {

    public static int parseToInt(String text) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            Output.printMessage("숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static int getNumberOfTickets(int money) throws IllegalArgumentException {
        if (money < LOTTO_PRICE) {
            Output.printMessage("1000원 이상으로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return money / LOTTO_PRICE;
    }

    public static String[] splitString(String text) {
        return text.split(",\\s*");
    }

    public static List<Number> parseToNumberArray(String[] splitText) {
        List<Number> winningNumbers = new ArrayList<>();
        for (String number : splitText) {
            int winningNumber = parseToInt(number);
            winningNumbers.add(new Number(winningNumber));
        }
        return winningNumbers;
    }

    public static String parseToPrintable(List<Number> ticket) {
        return String.join(", ", ticket.toString());
    }
}