package domain;

import java.util.Comparator;
import java.util.List;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Numbers sort() {
        numbers.sort(Comparator.naturalOrder());
        return new Numbers(numbers);
    }

    public Integer calculateHits(Numbers winningNumbers) {
        Integer hits = 0;
        for(Integer number : winningNumbers.getNumbers()) {
            if(numbers.contains(number)) {
                hits++;
            }
        }
        return hits;
    }
}
