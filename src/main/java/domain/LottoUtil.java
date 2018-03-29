package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoUtil {
    public static int getNumOfLotto(int i) {
        return i / 1000;
    }

    public static List<Integer> getRandNumbers() {
        List<Integer> numbers = IntStream.range(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }


}
