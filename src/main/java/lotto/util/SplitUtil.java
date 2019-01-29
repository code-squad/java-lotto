package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class SplitUtil {

    private static String prizeBlankRemoval(String input) {
        return input.replaceAll(" ", "");
    }

    private static String[] prizeSplit(String input) {
        String[] prize = prizeBlankRemoval(input).split(",");
        return prize;
    }

    public static List<Integer> prizeList(String input) {
        List<Integer> prizes = new ArrayList<>();
        for (String prize : (prizeSplit(input))) {
            prizes.add((Integer.parseInt(prize)));
        }
        return prizes;
    }
}