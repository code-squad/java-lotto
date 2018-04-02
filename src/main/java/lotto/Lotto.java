package lotto;

import input.Input;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    private List<String> right;
    static ArrayList<Integer> counts = new ArrayList<>();
    static List<Integer> numbers;
    static {
        numbers = init();
    }

    public Lotto() {
        Collections.shuffle(numbers);
        lotto = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lotto.add(numbers.get(i));
        }
    }

    public Lotto(List<String> manual) {
        lotto = new ArrayList<>();
        for(int i = 0; i < manual.size(); i++) {
            Lotto lotto = new Lotto(manual.get(i));
        }
    }

    public Lotto(String string) {
        right = Arrays.asList(string.split(","));
        lotto = new ArrayList<>();
        for (String s: right) {
            lotto.add(Integer.parseInt(s));
        }
    }

    public static List<Integer> init() {
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            values.add(i);
        }
        return values;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public List<String> getRight() {
        return right;
    }

    public List<Integer> checkNumber(Lotto right) {
        int count = 0;
        for(int i = 0; i < right.getRight().size(); i++) {
            if(lotto.contains(Integer.parseInt(right.getRight().get(i))))
                count++;
        }
        counts.add(count);
        return counts;
    }
}
