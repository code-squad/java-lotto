package lotto;

import input.Input;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    private List<Integer> right;
    private List<Integer> lottoNumber;
    private List<String> str;
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

    public Lotto(String string) {
        str = Arrays.asList(string.split(","));
        lottoNumber = new ArrayList<>();
        for (String s: str) {
            lottoNumber.add(Integer.parseInt(s));
        }

    }

    public Lotto(ArrayList<Integer> input) {
        right = input;
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

    public List<Integer> getRight() {
        return right;
    }

    public ArrayList<Integer> checkNumber(Lotto right) {
        int count = 0;
        for(int i = 0; i < right.getRight().size(); i++) {
            if(lotto.contains(right.getRight().get(i)))
                count++;
        }
        counts.add(count);
        return counts;
    }
}
