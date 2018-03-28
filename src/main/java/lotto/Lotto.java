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

    public Lotto(String string) {
        right = Arrays.asList(string.split(","));
<<<<<<< HEAD
        System.out.println("Lotto 객체생성 " + getRight());
=======
        lotto = new ArrayList<>();
        for (String s: right) {
            lotto.add(Integer.parseInt(s));
        }
>>>>>>> 80e6998bd7808e35b79848303683d11e08a70492
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
        System.out.println("당첨번호입력값 from checkNumber method " + getRight());
        for(int i = 0; i < right.getRight().size(); i++) {
            if(lotto.contains(Integer.parseInt(right.getRight().get(i))))
                count++;
        }
        counts.add(count);
        return counts;
    }
}
