package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto() {
        lottoNumbers = new LottoNumbers(cutNumberSix(makeNumbers()));
    }

    private List<Integer> makeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(1, 46).forEach(i -> numbers.add(i));
        return numbers;
    }

    private List<Integer> cutNumberSix(List<Integer> numbers) {
        List<Integer> cutNumbers = new ArrayList<>();
        Collections.shuffle(numbers);
        IntStream.range(0, 6).forEach(i -> cutNumbers.add(numbers.get(i)));
        return cutNumbers;
    }

    public int checkTheAnswerNumbers(List<Integer> numbers) {
        return lottoNumbers.checkTheWinningNumbers(numbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(lottoNumbers.toString());
        sb.append("]");
        return sb.toString();
    }
}
