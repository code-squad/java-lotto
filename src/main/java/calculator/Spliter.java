package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Spliter {

    List<Positive> split(String input);

    boolean isSpliterable(String input);

    default Matcher getMatcher(String input, String delimiter) {
        return Pattern.compile(delimiter).matcher(input);
    }

}
