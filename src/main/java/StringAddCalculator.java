import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int add(String text) {
        if (isBlank(text)){
            return 0;
        }
        return sum(filterNegativeNum(convertToInteger(parsePattern(text))));
    }

    private boolean isBlank(String text){
        if (text.isEmpty()){
            return true;
        }
        if (text == null){
            return true;
        }
        return false;
    }

    private String[] parsePattern(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return splitString(text);
    }

    private String[] splitString(String text){
        String[] parsed = text.split(",|:");
        return parsed;
    }
    private List<Integer> convertToInteger(String[] strings){
        List<Integer> result = new ArrayList<>();
        for (String s : strings){
            result.add(new Integer(String.valueOf(s)));
        }
        return result;
    }
    private List<Integer> filterNegativeNum(List<Integer> numbers){
        for (Integer number: numbers){
            if (number < 0){
                throw new RuntimeException("음수가 포함되어 있습니다");
            }
        }
        return numbers;
    }
    private int sum(List<Integer> numbers){
        int sum = 0;
        for (Integer n: numbers){
            sum+= n;
        }
        return sum;
    }
}
