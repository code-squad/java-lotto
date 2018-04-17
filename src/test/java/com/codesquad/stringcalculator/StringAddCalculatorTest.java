package com.codesquad.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    private StringAddCalculator calculator;

    @Before
    public void setup() {
        calculator = new StringAddCalculator();
    }

    @Test
    public void Empty_문자열() {
        Positive result = calculator.add("");
        assertThat(result).isEqualTo(new Positive(0));
    }

    @Test
    public void Null_문자열() {
        Positive result = calculator.add(null);
        assertThat(result).isEqualTo(new Positive(0));
    }

    @Test
    public void Comma_문자열() {
        Positive result = calculator.add("1,2");
        assertThat(result).isEqualTo(new Positive(3));
    }

    @Test
    public void 단일항() {
        Positive result = calculator.add("5");
        assertThat(result).isEqualTo(new Positive(5));
    }

    @Test
    public void 콜론_문자열() {
        Positive result = calculator.add("1,2:3");
        assertThat(result).isEqualTo(new Positive(6));
    }

    @Test
    public void Custom_문자열_세미콜론() {
        Positive result = calculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(new Positive(6));
    }

    @Test
    public void Custom_문자열_느낌표() {
        Positive result = calculator.add("//!\n3!4!5");
        assertThat(result).isEqualTo(new Positive(12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수() {
        Positive add = calculator.add("-1,2,3");
        assertThat(add).isEqualTo(new Positive(4));
    }
}
