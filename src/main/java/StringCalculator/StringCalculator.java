package StringCalculator;

public class StringCalculator {

    public static int add(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            return 0;
        }

        Splitter splitter = SplitterFactory.getSplitter(inputValue);
        return sum(splitter.split(inputValue));
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += stringToInt(number);
        }
        return sum;
    }

    private static int stringToInt(String number) {
        return checkNegativeNumber(Integer.parseInt(number));
    }

    private static int checkNegativeNumber(int value) {
        if (value < 0) {
            throw new RuntimeException();
        }
        return value;
    }

}