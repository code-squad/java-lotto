package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_COST = 1000;
    public static final int LOTTO_PICK_COUNT = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        validate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        if(numbers.size() < 6){
            throw new IllegalArgumentException("번호 입력을 잘못하였습니다.");
        }

        for(int number : numbers){
            if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER){
                throw new IllegalArgumentException("번호 입력을 잘못하였습니다.");
            }
        }
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
