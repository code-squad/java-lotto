package com.codesquad.lotto.vo;

import java.util.Objects;

public class Money {
    private final int value;

    public Money(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("마이너스 금액은 생성할 수 없습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }


    public int divide(final Money money) {
        if (money.getValue() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return this.value / money.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}
