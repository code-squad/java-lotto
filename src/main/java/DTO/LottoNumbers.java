package DTO;

import domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private static final Integer LOTTO_NUMBER_SIZE = 6;
    List<LottoNumber> numbers;

    public LottoNumbers() {
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers createAutoNumbers(){
        this.numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            numbers.add(new LottoNumber().autoCreateNumber());
        }
        return this;
    }

    public void sortingNumber() {
        Collections.sort(this.numbers);
    }

    public Integer isHitNumber(LottoNumber winningNumber) {
        return this.numbers.contains(winningNumber)? 1: 0;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private boolean isEquals(int i, List<LottoNumber> that) {
        return this.numbers.get(i).equals(that.get(i));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o ) return true;
        LottoNumbers that = (LottoNumbers) o;
        if (o == null || this.numbers.size() != that.numbers.size() ||this.numbers == null || getClass() != o.getClass()) return false;

        for (int i = 0; i < this.numbers.size(); i++) {
            if (!isEquals(i, that.numbers))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(" " + this.numbers.get(i) + " ");
        }
        sb.append("]");
        sb.append("\n");
        return sb.toString();
    }

}
