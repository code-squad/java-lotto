package stringcalculator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class StringCalculator {

    public static int add(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sum(toInt(tokens));
        }
        return sum(toInt(split(text)));
    }


    private static String[] split(String text) {
        return text.split(",|:");
    }

    private static int[] toInt(String[] strNums) {
        int[] nums = new int[strNums.length];
        int i = 0;
        for (String num : strNums) {
            if (isPositiveNumber(num)) {
                nums[i++] = Integer.parseInt(num);
            }
        }
        return nums;
    }

    private static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static boolean isPositiveNumber(String str) {
        int num = Integer.parseInt(str);
        if (num < 0) {
            throw new RuntimeException();
        }
        return true;
    }


}
