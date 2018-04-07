import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSpliter implements Spliter {

    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private String input;

    CustomSpliter(String input) {
        this.input = input;
    }

    @Override
    public Positive split() {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return new Positive(getSplited(tokens));
        }
        return new Positive();
    }

    private List<Integer> getSplited(String[] tokens) {
        return Arrays.stream(tokens).map(Integer::new).collect(Collectors.toList());
    }
}
