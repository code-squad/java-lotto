package lotto.view;

import lotto.domain.Number;

import java.util.ArrayList;
import java.util.List;

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

    public static String[] splitString(String text) throws IllegalArgumentException {
        String[] split = text.split(",\\s*");
        if (split.length == 6) {
            return split;
        }
        Output.printMessage("당첨 번호 수(6개)가 맞지 않습니다.");
        throw new IllegalArgumentException();
    }

    public static List<Number> parseToNumberArray(String[] splitText) {
        List<Number> winningNumbers = new ArrayList<>();
        for (String number : splitText) {
            winningNumbers.add(parseToNumber(parseToInt(number)));
        }
        return winningNumbers;
    }

    public static Number parseToNumber(int num) {
        return new Number(num);
    }

    public static String parseToPrintable(List<Number> ticket) {
        return String.join(", ", ticket.toString());
    }
}