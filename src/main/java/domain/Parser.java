package domain;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final int PREVIOUS_WINNER_NUMBER_LENGTH = 6;

    public static List<Integer> parsing (String parsingTarget) {
        List<Integer> parsedArr = new ArrayList<>();
        String[] parse = parsingTarget.split(",");
        numLengthCheck(parse);
        for (String s : parse) {
            parsedArr.add(Integer.parseInt(s));
        }
        return parsedArr;
    }

    private static void numLengthCheck(String[] previousWinNum) {
        if (previousWinNum.length != PREVIOUS_WINNER_NUMBER_LENGTH) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 숫자 6개입니다.");
        }
    }

}
