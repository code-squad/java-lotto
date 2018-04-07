package com.codesquad.stringcalculator;

import java.util.Objects;

public class Positive {

    private final int number;

    public Positive(int number) {
        validatePositive(number);
        this.number = number;
    }

    public Positive(String number) {
        int parsedNumber = Integer.parseInt(number);
        validatePositive(parsedNumber);
        this.number = parsedNumber;
    }

    public Positive add(Positive positive) {
        return new Positive(this.number + positive.number);
    }

    private void validatePositive(int number) {
        if (number < 0)
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }
}
