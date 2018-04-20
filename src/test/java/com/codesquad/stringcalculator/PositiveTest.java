package com.codesquad.stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveTest {
    @Test
    public void 양수() {
        Positive positive = new Positive(1);
        assertThat(positive).isEqualTo(new Positive(1));
    }

    @Test
    public void 다른양수() {
        Positive positive = new Positive(2);
        assertThat(positive).isEqualTo(new Positive(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수() {
        Positive positive = new Positive(-1);
    }

    @Test
    public void 양수문자열() {
        Positive positive = new Positive("1");
        assertThat(positive).isEqualTo(new Positive(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수문자열() {
        Positive positive = new Positive("-2");
    }

    @Test
    public void 덧셈() {
        Positive leftOperand = new Positive(3);
        Positive sum = leftOperand.add(new Positive(5));
        assertThat(sum).isEqualTo(new Positive(8));
    }

    @Test
    public void 다른덧셈() {
        Positive leftOperand = new Positive(4);
        Positive sum = leftOperand.add(new Positive(7));
        assertThat(sum).isEqualTo(new Positive(11));
    }
}
