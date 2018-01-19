package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final  List<LottoNo> LOTTO_NUMBER_RANGE = IntStream.range(1, 46).boxed().map(i -> new LottoNo(i)).collect(Collectors.toList());
    private List<LottoNo> numbers;

    public Lotto(List<LottoNo> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    public Lotto() {
        numbers = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBER_RANGE, new Random());
        numbers = LOTTO_NUMBER_RANGE.subList(0, 6);
    }


    public List<LottoNo> getNumbers() {
        return this.numbers;
    }

    public String joinNumbers(){
        return this.numbers.stream().map(lottoNo -> lottoNo.getNumber().toString()).collect(Collectors.joining(","));
    }
}
