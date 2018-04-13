package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String expression) {
        if (isBlank(expression)) {
            return 0;
        }

        return calculate(toInts(split(expression)));
    }

    private static int calculate(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toInts(String[] splitNumber) {
        int[] result = new int[splitNumber.length];
        for (int i = 0; i < splitNumber.length; i++) {
            result[i] = toInt(splitNumber[i]);
        }
        return result;
    }

    private static int toInt(String splitNumber) {
        int result = Integer.parseInt(splitNumber);

        if (result < 0) {
            throw new RuntimeException();
        }
        return Integer.parseInt(splitNumber);
    }

    private static String[] split(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return expression.split(",|:");
    }

    private static boolean isBlank(String expression) {
        return expression == null || expression.isEmpty();
    }
}
