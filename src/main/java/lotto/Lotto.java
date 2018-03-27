package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    private List<Integer> right;
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

    public Lotto(ArrayList<Integer> input) {
        right = new ArrayList<>();
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
