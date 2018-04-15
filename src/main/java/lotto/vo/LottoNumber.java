package lotto.vo;

import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int FIRST_IDX = 0;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private static final List<Integer> seedNumbers;
    static {
        seedNumbers = IntStream
                .rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    private Set<Integer> numbers;

    private LottoNumber(Set<Integer> numbers) {
        if(isLottoNumberSize(numbers)) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    public static LottoNumber of() {
        Collections.shuffle(seedNumbers);
        return LottoNumber.of(seedNumbers.subList(FIRST_IDX, LOTTO_NUMBER_SIZE));
    }

    public static LottoNumber of(List<Integer> numbers) {
        return LottoNumber.of(Sets.newHashSet(numbers));
    }

    public static LottoNumber of(Set<Integer> numbers) {
        return new LottoNumber(numbers);
    }

    private static boolean isLottoNumberSize(Set<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_SIZE;
    }

    static boolean isLottoNumber(int number) {
        return seedNumbers.contains(number);
    }

    public int matchCount(LottoNumber lottoNumber) {
        int matchCount = 0;
        for (Integer number : lottoNumber.numbers) {
            if (this.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean matchBonus(BonusNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.toInt());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return numbers.containsAll(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        Object[] arr = numbers.toArray();
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }
}
