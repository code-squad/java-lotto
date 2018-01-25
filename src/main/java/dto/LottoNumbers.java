package dto;

import domain.lotto.LottoNumber;

import java.util.*;

public class LottoNumbers {
    public static final Integer LOTTO_NUMBER_SIZE = 6;
    private SortedSet<LottoNumber> numbers;

    public LottoNumbers() {
        this.numbers = new TreeSet<>();

        while(numbers.size() > LOTTO_NUMBER_SIZE){
            numbers.add(new LottoNumber().autoCreateNumber());
        }
    }

    public LottoNumbers(SortedSet<LottoNumber> numbers) {
        this.numbers = numbers;
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
