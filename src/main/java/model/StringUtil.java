package model;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static List<Integer> stringToList(String result) {
        List<Integer> resultNumbers = new ArrayList();
        for (String value : result.split(",")) {
            resultNumbers.add(Integer.parseInt(value));
        }
        return resultNumbers;
    }
}
