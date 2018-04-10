package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sangsik.kim
 */
public class StringUtil {
    private static final String DEFAULT_SEPARATOR = ",|:";

    public static String getSeparator(final String text) {
        Matcher matcher = Pattern.compile("//(.)\n").matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return DEFAULT_SEPARATOR;
    }

    public static String getTextWithoutSeparator(final String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return text;
    }
}
