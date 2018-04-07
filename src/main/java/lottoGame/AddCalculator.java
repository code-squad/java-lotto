package lottoGame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculator {

    public static int add(String text) {
        return isEmpty(text) ? 0 : sum(text);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    private static int sum(String text){
        return addNums(toInts(splitComma(getText(text),getDelimeter(text))));
    }

    private static String getText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2);
        }

        return text;
    }

    private static String getDelimeter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return ",|:|"+m.group(1);
        }

        return ",|:";
    }

    private static String[] splitComma(String text,String delemeter) {
        return text.split(delemeter);
    }

    private static int[] toInts(String[] numArr) {
        int[] numIntArr = new int[numArr.length];
        for(int i=0; i<numArr.length; i++){
            numIntArr[i] = Integer.valueOf(numArr[i]);
        }

        return checkMinus(numIntArr);
    }

    private static int[] checkMinus(int[] numArr) {
        for(int num : numArr){
            if(num < 0)
                throw new RuntimeException();
        }

        return numArr;

    }

    private static int addNums(int[] numArr) {
        int sum = 0;
        for(int num : numArr){
            sum += num;
        }

        return sum;
    }

}
