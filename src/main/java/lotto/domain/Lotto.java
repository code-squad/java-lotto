package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_COST = 1000;
    public static final int LOTTO_PICK_COUNT = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        this.numbers = numbers;
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        numbers.sort(Comparator.comparingInt(o -> o));

        return Arrays.toString(numbers.toArray());
    }
}
