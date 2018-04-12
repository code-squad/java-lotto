package lottoGame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int addOperate(String text) {

        return isEmptyValue(text) ? 0 : sumValue(toInts(getSplit(getRealText(text),getCustomDelimetor(text))));
    }

    private static String getRealText(String text) {
        Matcher m = getMatcher(text);
        if(m.find()) {
            return m.group(2);
        }
        return text;
    }

    private static String getCustomDelimetor(String text) {
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = getMatcher(text);
        String customDelimetor = null;
        if (m.find()) {
            customDelimetor = m.group(1);
        }
        return customDelimetor;
    }

    private static Matcher getMatcher(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    private static boolean isEmptyValue(String text) {
        return (text == "" || text == null);
    }

    private static int[] toInts(String[] values) {
        int[] returnValues = new int[values.length];
        int i = 0;
        for(String value:values) {
            returnValues[i++] = isMinusValue(Integer.valueOf(value));
        }
        return returnValues;
    }

    private static int isMinusValue(int value) {
        if(value < 0) {
            throw new RuntimeException();
        }
        return value;
    }

    private static int sumValue(int[] values) {
       int sum = 0;
       for(int value:values) {
           sum += value;
       }
       return sum;
    }

    private static Integer getIntegerValue(String operator) {
        return Integer.valueOf(operator);
    }


    private static String[] getSplit(String operators,String customDelimeter) {
        return operators.split(",|:"+"|"+customDelimeter);
    }
}
