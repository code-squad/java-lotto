package utils;

import java.util.Arrays;
import java.util.List;

public class StringParseUtil {

    public static List<String> parsingTextNumber(String text) {
        return Arrays.asList(text.replaceAll(" ", "").split(","));
    }
}
