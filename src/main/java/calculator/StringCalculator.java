package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {
    static int add(String text) {
        return sum(getTokens(text));
    }

    private static int sum(String[] tokens) {
        int sum = 0;
        for (int num : parseToIntArray(tokens)) {
            sum += num;
        }
        return sum;
    }

    private static String[] getTokens(String text) {
        Matcher m = getMatcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }

        return text.split("[,:]");
    }

    private static int[] parseToIntArray(String[] tokens) {
        int[] intArr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            intArr[i] = parseToInt(tokens[i]);
        }
        return intArr;
    }

    private static int parseToInt(String token) {
        int numberToken = Integer.parseInt(token);
        if (numberToken < 0) {
            throw new IllegalArgumentException();
        }
        return numberToken;
    }

    private static Matcher getMatcher(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }
}
