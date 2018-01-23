package lotto.domain;

import lotto.exception.DuplicatedNumberException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<LottoNo> numbers;

    public Lotto(List<LottoNo> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new DuplicatedNumberException("로또 숫자에 중복이 있습니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    public Lotto() {
        List<LottoNo> LOTTO_NUMBER_RANGE = IntStream.range(1, 46).boxed().map(i -> new LottoNo(i)).collect(Collectors.toList());
        this.numbers = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBER_RANGE, new Random());
        this.numbers = LOTTO_NUMBER_RANGE.subList(0, 6);
    }

    private boolean hasDuplicatedNumber(List<LottoNo> inputLottos) {
        return inputLottos.stream().filter(i -> Collections.frequency(inputLottos , i) > 1).count() > 0;
    }

    public List<LottoNo> getNumbers() {
        return this.numbers;
    }

    public String joinNumbers(){
        return this.numbers.stream().map(lottoNo -> lottoNo.getNumber().toString()).collect(Collectors.joining(","));
    }
}
