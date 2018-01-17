package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(){
        numbers = new ArrayList<Integer>();

        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }

        getRandomLotto();
    }

    private List<Integer> getRandomLotto() {
        List<Integer> randomLotto = new ArrayList<Integer>();
        shuffle();
        numbers = numbers.subList(0, 6);
        return sort(numbers);
    }

    private List<Integer> sort(List<Integer> randomLotto) {
        Collections.sort(randomLotto);
        return randomLotto;
    }


    private void shuffle() {
        Collections.shuffle(numbers);
    }

    public int countMatchLotto(List<Integer> luckyNum) {
        int count = 0;
        for(int number : numbers){
            count += matchYn(luckyNum, number);
        }
        return count;
    }

    public int matchYn(List<Integer> luckyNum, int number) {
        if(luckyNum.contains(number)){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
