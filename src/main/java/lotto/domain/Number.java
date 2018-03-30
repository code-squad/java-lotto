package lotto.domain;

import lotto.view.Output;

import java.util.Objects;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;

    Number(int number) {
        this.number = checkValid(number);
    }

    private int checkValid(int number) throws IllegalArgumentException {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            Output.printMessage("1 부터 45 사이의 숫자만 있어야 합니다.");
            throw new IllegalArgumentException();
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}