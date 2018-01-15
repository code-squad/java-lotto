package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private Set<Integer> numbers;

    private Set<Integer> result;

    public static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    public Lotto(Set<Integer> numbers) {
       this.numbers = numbers;
    }

    public Lotto() {
        numbers = new HashSet<>();
        while (numbers.size() < 6) {
            Random random = new Random();
            numbers.add(LOTTO_NUMBERS.get(random.nextInt(45))+1);
        }
    }
    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    public String joinNumbers(){
        return this.numbers.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(","));
    }

    public Set<Integer> getResult(Set<Integer> winNumbers) {
        result = new HashSet<>();
        for (Integer number : numbers) {
            if (winNumbers.contains(number)) {
                result.add(number);
            }
        }
        return result;
    }



}
