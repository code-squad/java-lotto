package com.codesquad.stringcalculator;

import org.junit.Test;

import static com.codesquad.stringcalculator.StringAddCalculator.add;
import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    public void Empty_문자열() {
        Positive result = add("");
        assertThat(result).isEqualTo(new Positive(0));
    }

    @Test
    public void Null_문자열() {
        Positive result = add(null);
        assertThat(result).isEqualTo(new Positive(0));
    }

    @Test
    public void Comma_문자열() {
        Positive result = add("1,2");
        assertThat(result).isEqualTo(new Positive(3));
    }

    @Test
    public void 단일항() {
        Positive result = add("5");
        assertThat(result).isEqualTo(new Positive(5));
    }

    @Test
    public void 콜론_문자열() {
        Positive result = add("1,2:3");
        assertThat(result).isEqualTo(new Positive(6));
    }

    @Test
    public void Custom_문자열_세미콜론() {
        Positive result = add("//;\n1;2;3");
        assertThat(result).isEqualTo(new Positive(6));
    }

    @Test
    public void Custom_문자열_느낌표() {
        Positive result = add("//!\n3!4!5");
        assertThat(result).isEqualTo(new Positive(12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수() {
        add("-1,2,3");
    }
}
