import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class CustomSpliter implements Spliter {

    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    @Override
    public List<Positive> split(String input) {
        Matcher m = getMatcher(input, CUSTOM_DELIMITER);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return getSplited(tokens);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public boolean isSpliterable(String input) {
        return getMatcher(input, CUSTOM_DELIMITER).find();
    }

    private List<Positive> getSplited(String[] tokens) {
        return Arrays.stream(tokens).map(Integer::new).map(Positive::new).collect(Collectors.toList());
    }
}
