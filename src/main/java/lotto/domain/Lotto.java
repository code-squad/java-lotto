package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    public Lotto() {
        numbers = new ArrayList<>();
        List<Integer> lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers, new Random());
        numbers = lottoNumbers.subList(0, 6);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public String joinNumbers(){
        return this.numbers.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(","));
    }

    public List<Integer> getResult(List<Integer> winNumber) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (winNumber.contains(number)) {
                result.add(number);
            }
        }
        return result;
    }

    public boolean hasBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }





}
