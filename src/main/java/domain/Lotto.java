package domain;

import java.util.List;

public class Lotto {

    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getNumOfMatches(List<Integer> answer) {
        return 3;
    }
}
