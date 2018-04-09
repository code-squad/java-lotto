package lotto;

import java.util.List;

public class Lotto {

    public List<Integer> numbers;

    public Lotto(Random random) {
        numbers = random.getLottoNumbers();
    }

    public int matchesNumber(List<Integer> luckyNumbers) {
        int count = 0;
        for (Integer luckyNumber : luckyNumbers) {
            if(isContains(luckyNumber)) {
                count++;
            }
        }

        return count;
    }

    private boolean isContains(Integer luckyNumber) {
        return this.numbers.contains(luckyNumber);
    }
}
