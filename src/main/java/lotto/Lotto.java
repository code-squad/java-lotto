package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Joeylee on 2018-01-13.
 */
public class Lotto {

    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
       this.numbers = numbers;
    }

    public void printLotto() {
        System.out.println(String.join(", ", numbers.toString()));
    }

    public int countMatchingAnswer(List<Integer> answer) {
        int matchCount =0;
        for (Integer integer : answer) {
            if(numbers.contains(integer)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
