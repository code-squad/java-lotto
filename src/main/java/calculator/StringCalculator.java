package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringCalculator {

    public Integer sum(String expression) {
        if(expression == null || expression.isEmpty()) {
            return 0;
        }

        return getNumbers(expression).sum();
    }

    private IntStream getNumbers(String expression) throws RuntimeException {
        return Arrays.stream(getSplitExpression(expression))
                .mapToInt(Integer::parseUnsignedInt);
    }

    private String[] getSplitExpression(String expression) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);

            return matcher.group(2)
                          .split(customDelimiter);
        }
        return expression.split(",|:");
    }
}
