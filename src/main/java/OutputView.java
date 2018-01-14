import java.util.Arrays;

public class OutputView {
    public static final String REGEX = ", ";
    private static final String UI_FORMAT = "[%s]";

    public static String lottoNumbersFormatting(int[] numbers) {
        return String.format(UI_FORMAT, String.join(REGEX, convertIntToString(numbers)));
    }

    private static String[] convertIntToString(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
    }
}
