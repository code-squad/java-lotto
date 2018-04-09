package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int COUNT_OF_SELECT_LOTTO = 6;
    private static final int LOTTO_PRICE = 1000;
    private int countOfLotto;
    private static List<Integer> number;

    static {
         number = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    }

    public int getCountOfLotto(int money) {
        countOfLotto = money / LOTTO_PRICE;
        return countOfLotto;
    }

    public List<Integer> getLottoNumber() {
        List<Integer> result = createLottoNumbers();
        return result;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> result = new ArrayList<>();
        Collections.shuffle(number);
        for (int index = 0; index < COUNT_OF_SELECT_LOTTO; index++) {
            result.add(number.get(0));
        }
        Collections.sort(result);
        return result;
    }
}
