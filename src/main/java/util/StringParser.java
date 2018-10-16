package util;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private static final String COMMA = ",";
    public static List<Integer> parseToNumbers(String input){
        String[] texts = splitWithComma(trimSpace(input));
        List<Integer> numbers = new ArrayList<>();
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
