package util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Integer> makeIntegerList(String input) {
        String[] str = input.split(",");
        return StringToInteger(str);
    }

    private static List<Integer> StringToInteger(String[] str) {
        List<Integer> winnerLotto = new ArrayList<>();
        for (String s : str) {
            winnerLotto.add(Integer.parseInt(s));
        }
        return winnerLotto;
    }
}
