package domain;

import java.util.Objects;

public class Number {

    private final int num;

    private Number(int num) {
        if (num > 45 || num <= 0){
            throw new RuntimeException("입력값은 1-45사이 입니다.");
        }
        this.num = num;
    }

    public static Number of(int num){
        return new Number(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return num == number.num;
    }

    @Override
    public int hashCode() {

        return Objects.hash(num);
    }
}
