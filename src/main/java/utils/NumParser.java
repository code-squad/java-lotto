package utils;

import java.util.ArrayList;
import java.util.List;

public class NumParser {
    public static final String COMMA = ",";

    private NumParser() {
    }

    public static List<Integer> parse(String inputWinningNums) {
        List<Integer> lottoNums = new ArrayList<>();
        for (String num : inputWinningNums.split(COMMA)) {
            lottoNums.add(Integer.parseInt(num.trim()));
        }
        return lottoNums;
    }
}
