package util;

import java.util.InputMismatchException;

public class Parser {
    public static int parseInteger(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("숫자형식으로 입력하세요.");
        }
    }
}
