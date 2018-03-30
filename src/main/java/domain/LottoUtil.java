package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoUtil {

    private static final int MIN_INCLUSIVE = 1;
    private static final int MAX_EXCLUSIVE = 46;

    public static List<Integer> getRandNumbers() {
        List<Integer> numbers = IntStream.range(MIN_INCLUSIVE, MAX_EXCLUSIVE).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    public static int checkReturnInputMoney(int money) {
        if (!validInputMoney(money)){
            throw new RuntimeException();
        }
        return money;
    }

    static boolean validInputMoney(int money) {
        return money > 0;
    }
}
