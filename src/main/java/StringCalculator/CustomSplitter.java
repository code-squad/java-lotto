package StringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {

    @Override
    public boolean supports(String inputValue) {
        if (Pattern.compile("//(.)\n(.*)").matcher(inputValue).find()) {
            return true;
        }
        return false;
    }

    @Override
    public String[] split(String inputValue) {
        return customSplit(inputValue);
    }

    private String[] customSplit(String inputValue) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputValue);
        m.find();
        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }

}