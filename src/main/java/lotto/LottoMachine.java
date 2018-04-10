package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int COUNT_OF_SELECT_LOTTO = 6;
    public static final int LOTTO_PRICE = 1000;
    private static List<Integer> number;

    static {
         number = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    }

    public int getCountOfLotto(int money) {
        return money / LOTTO_PRICE;
    }

    public static List<Integer> getLottoNumber() {
        return createLottoNumbers();
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> result = new ArrayList<>();
        Collections.shuffle(number);
        for (int index = 0; index < COUNT_OF_SELECT_LOTTO; index++) {
            result.add(number.get(index));
        }
        Collections.sort(result);
        return result;
    }
}
