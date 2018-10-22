package util;

import java.util.HashSet;
import java.util.Set;

public class StringParser {
    private static final String COMMA = ",";
    public static Set<Integer> parseToNumbers(String input){
        String[] texts = splitWithComma(trimSpace(input));
        Set<Integer> numbers = new HashSet<>();
        for (String text : texts) {
            numbers.add(parseToNumber(text));
        }
        return numbers;
    }

    public static String[] splitWithComma(String wholeText){
        return wholeText.split(COMMA);
    }

    public static int parseToNumber(String text){
        return Integer.parseInt(text);
    }

    public static String trimSpace(String wholeText){
        return wholeText.replaceAll("\\s", "");
    }

}
