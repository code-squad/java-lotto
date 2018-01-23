package lotto.domain;

import java.util.Objects;

class LottoNumber implements Comparable<LottoNumber> {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;

    private int number;

    LottoNumber(int number) {
        validate(number);

        this.number = number;
    }

    private void validate(int number){
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }
}
