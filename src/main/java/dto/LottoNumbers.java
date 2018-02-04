package dto;

import domain.lotto.InputString;
import domain.lotto.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final Integer LOTTO_NUMBER_SIZE = 6;
    private SortedSet<LottoNumber> numbers;

    private LottoNumbers() {
        this.numbers = new TreeSet<>();

        while(numbers.size() < LOTTO_NUMBER_SIZE){
            numbers.add(LottoNumber.of());
        }
    }

    private LottoNumbers(SortedSet<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers of(){
        return new LottoNumbers();
    }

    public static LottoNumbers of(String text) {
        SortedSet<LottoNumber> newNumbers
                = new TreeSet<>(
                ParsingLottoNumbers.of(InputString.of(text))
                        .getNumbers()
                        .stream()
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()));
        return LottoNumbers.of(newNumbers);
    }

    public static LottoNumbers of(SortedSet<LottoNumber> newNumbers) {
        return new LottoNumbers(newNumbers);
    }

    public Integer isHitNumber(LottoNumber winningNumber) {
        return this.numbers.contains(winningNumber)? 1: 0;
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return this.numbers.size() != that.numbers.size() || this.numbers.containsAll(that.numbers);
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        this.numbers.forEach(number -> sb.append(" ").append(number).append(" "));

        sb.append("]");
        sb.append("\n");
        return sb.toString();
    }
}
