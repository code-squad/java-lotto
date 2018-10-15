package domain;

import java.util.List;

public class Lotto {
    private static final int MAX = 45;
    private static final int MIN = 1;

    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.isValid();
    }

    private void isValid(){
        for (Integer number : numbers) {
            if(number > MAX || number < MIN) new IllegalArgumentException();
        }
    }
}
