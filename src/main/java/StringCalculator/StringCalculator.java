package StringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private int sum = 0;
    public int add(String text) throws Exception {
        if(nullOrEmpty(text)){
            return 0;
        }

        Matcher customPattern = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] splitValues = text.split(",|:");
        if (customPattern.find()) {
            splitValues = returnToken(customPattern);
        }
        return sum(sum, splitValues);
    }

    private String[] returnToken(Matcher customPattern) {
        String customDelimiter = customPattern.group(1);
        String[] tokens = customPattern.group(2).split(customDelimiter);
        return tokens;
    }

    private boolean nullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

     private int sum(int sum, String[] splitNumber) {
        for(String number : splitNumber){
           sum += check(Integer.parseInt(number));
        }
        return sum;
    }

    private int check(int number) {
        if(number < 0){
           throw new RuntimeException("RuntimeException22");
        }
        return number;
    }
}
