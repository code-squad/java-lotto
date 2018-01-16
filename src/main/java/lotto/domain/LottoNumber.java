package lotto.domain;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Moonchan on 2018. 1. 13..
 */
public class LottoNumber {

    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    List<Integer> numbers;

    public LottoNumber() {
        this(new AutoLottoNumberGenerator().generateNumbers());
    }

    public LottoNumber(List<Integer> numbers) {
        checkValid(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    public int countMatchNumber(LottoNumber other) {
        List<Integer> combined = new ArrayList<>();
        combined.addAll(this.numbers);
        combined.addAll(other.numbers);
        return LOTTO_NUMBERS_SIZE * 2 - (int)combined.stream().distinct().count();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void checkValid(@Nonnull List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또번호는 " + LOTTO_NUMBERS_SIZE + "개의 숫자로 초기화해야합니다.");
        }

        if(numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }

        for (int number : numbers) {
            if(number < 1 || number > MAX_NUMBER) {
                throw new IllegalArgumentException("로또 번호의 범위는 1부터 " + MAX_NUMBER + "까지 입니다.");
            }
        }
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.stream().map(v -> v.toString()).collect(Collectors.toList()));
    }


}
