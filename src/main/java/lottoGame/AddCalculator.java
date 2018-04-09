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
        return addNums(toInts(splitText(text)));
    }

    private static String[] splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }

        return text.split(",|:");
    }

    private static int[] toInts(String[] nums) {
        int[] intValues = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            intValues[i] = Integer.valueOf(nums[i]);
        }

        return checkMinus(intValues);
    }

    private static int[] checkMinus(int[] nums) {
        for(int num : nums) {
            if(num < 0)
                throw new RuntimeException();
        }

        return nums;
    }

    private static int addNums(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        return sum;
    }

}
