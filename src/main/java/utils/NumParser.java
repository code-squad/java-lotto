package utils;

import java.util.ArrayList;
import java.util.List;

public class NumParser {
    public static final String COMMA = ",";

    private NumParser() {
    }

    public static List<Integer> parse(String inputWinningNums) {
        List<Integer> winningNums = new ArrayList<>();
        for (String num : inputWinningNums.split(COMMA)) {
            winningNums.add(Integer.parseInt(num.trim()));
        }
        return winningNums;
    }
}
