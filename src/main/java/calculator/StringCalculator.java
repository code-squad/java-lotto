package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String expression) {
        if (isEmpty(expression)) {
            return 0;
        }

        return sum(parseInts(split(expression)));
    }

    private static String[] split(String expression) {
        return getSplitters(expression).split(expression);
    }

    private static Splitter getSplitters(String expression) {
        return initSplitters().stream()
                .filter(splitter -> splitter.isSupport(expression))
                .findFirst()
                .orElseThrow(UnsupportedOperationException::new);
    }

    private static List<Splitter> initSplitters() {
        return Arrays.asList(
                    new CustomSplitter(),
                    new DefaultSplitter()
            );
    }

    private static int[] parseInts(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(i -> validateNumber(Integer.parseInt(i)))
                .toArray();
    }

    private static int validateNumber(int number) {
        if (0 > number) {
            throw new IllegalArgumentException("정수값만 입력할 수 있습니다.");
        }
        
        return number;
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static boolean isEmpty(String expression) {
        return expression == null || expression.equals("");
    }


    interface Splitter {
        String[] split(String expression);

        boolean isSupport(String expression);
    }

    static class DefaultSplitter implements Splitter {
        private final static String PATTERNS = ",|:";
        private final static String CUSTOM_PATTERNS = "//(.)\n(.*)";
        
        @Override
        public String[] split(String expression) {
            return expression.split(PATTERNS);
        }

        @Override
        public boolean isSupport(String expression) {
            Matcher m = Pattern.compile(CUSTOM_PATTERNS).matcher(expression);
            return m.find() == false;
        }
    }

    static class CustomSplitter implements Splitter {
        private final static String PATTERNS = "//(.)\n(.*)";

        @Override
        public String[] split(String expression) {
            Matcher m = Pattern.compile(PATTERNS).matcher(expression);
            if (m.find()) {
                String delimiter = m.group(1);
                return m.group(2).split(delimiter);
            }
            return null;
        }

        @Override
        public boolean isSupport(String expression) {
            Matcher m = Pattern.compile(PATTERNS).matcher(expression);
            return m.find();
        }
    }
}

