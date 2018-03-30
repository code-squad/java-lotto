package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parse {

    private static final int MIN = 1;
    private static final int MAX = 45;

    public static List<Integer> parse(String numbers) {
        return divideNum(escapeNum(numbers));
    }

    public static String[] escapeNum(String numbers) {
        return numbers.split(",");
    }

    public static int intOf(String num) {
        return Integer.parseInt(num.trim());
    }

    public static List<Integer> divideNum(String[] numbers) {
        List<Integer> lotto = new ArrayList<>();
        for (String num : numbers) {
            int oneNumber = intOf(num);
            overException(oneNumber);   //1부터 45까지만 입력되는지 확인
            lotto.add(oneNumber);
        }
        return lotto;
    }

    public static void overException(int lottoNumber) {
        if (lottoNumber < MIN || MAX < lottoNumber)
            throw new IllegalArgumentException("1부터 45까지만 입력해 주세요.");
    }
}
