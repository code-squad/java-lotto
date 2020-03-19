package util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {

    public static List<Integer> convertToInt(String[] strings) {
        return Stream.of(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String[] split(String str) {
        return str.split(", ");
    }
}
