package domain;

import java.util.List;

public class Lotto {
    public static final int MAX = 45;
    public static final int MIN = 1;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.isValid();
    }

    private void isValid(){
        if(!this.isValidBoundary() || !isValidSize()) new IllegalArgumentException();
    }

    private boolean isValidSize(){
        return this.numbers.size() == LOTTO_NUMBERS_SIZE;
    }

    private boolean isValidBoundary(){
        for (Integer number : this.numbers) {
            if(number > MAX || number < MIN) return false;
        }
        return true;
    }
}
