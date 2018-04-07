import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class DefaultSpliter implements Spliter {

    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public List<Positive> split(String input) {
        Matcher m = getMatcher(input, DEFAULT_DELIMITER);

        if (m.find()) {
            String[] tokens= input.split(DEFAULT_DELIMITER);
            return getSplited(tokens);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public boolean isSpliterable(String input) {
        return getMatcher(input, DEFAULT_DELIMITER).find();
    }

    private List<Positive> getSplited(String[] input) {
        return Arrays.stream(input).map(Integer::getInteger).map(Positive::new).collect(Collectors.toCollection(ArrayList::new));
    }
}
