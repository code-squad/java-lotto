package com.codesquad.stringcalculator;

import org.junit.Test;

import static com.codesquad.stringcalculator.StringAddCalculator.add;
import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    public void Empty_문자열() {
        int result = add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void Null_문자열() {
        int result = add(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void Comma_문자열() {
        int result = add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 단일항() {
        int result = add("5");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 콜론_문자열() {
        int result = add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void Custom_문자열_세미콜론() {
        int result = add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void Custom_문자열_느낌표() {
        int result = add("//!\n3!4!5");
        assertThat(result).isEqualTo(12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수() {
        add("-1,2,3");
    }
}
