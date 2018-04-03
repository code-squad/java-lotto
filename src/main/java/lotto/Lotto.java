package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    static List<Integer> numbers;
    static {
        numbers = init();
    }
    public Lotto() {
        Collections.shuffle(numbers);
        lotto = new ArrayList<>();
        for(int i = 0; i < 6; i++)
            lotto.add(numbers.get(i));
    }

    public Lotto(String number) {
        lotto = new ArrayList<>();
        List<String> stringNum = Arrays.asList(number.split(","));
        for (String s: stringNum) {
            lotto.add(Integer.parseInt(s));
        }
    }

    public static List<Integer> init() {
        List<Integer> values = new ArrayList<>();
        for(int i = 1; i < 46; i++)
            values.add(i);
        return values;
    }

    public Integer countNumber(Lotto winningNumber) {
        int count = 0;
        for(int i = 0; i < winningNumber.getLotto().size(); i++) {
            if (getLotto().contains(winningNumber.getLotto().get(i)))
                count++;
        }
        return count;
    }

    public Integer lottoSize() {
        return lotto.size();
    }

    public List<Integer> getLotto() {
        return lotto;
    }

}
