package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final  List<LottoNo> LOTTO_NUMBER_RAGNE = IntStream.range(1, 46).boxed().map(i -> new LottoNo(i)).collect(Collectors.toList());
    private List<LottoNo> numbers;

    public Lotto(List<LottoNo> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    public Lotto() {
        numbers = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBER_RAGNE, new Random());
        numbers = LOTTO_NUMBER_RAGNE.subList(0, 6);
    }

    public List<LottoNo> getNumbers() {
        return this.numbers;
    }

    public String joinNumbers(){
        return this.numbers.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(","));
    }
}
