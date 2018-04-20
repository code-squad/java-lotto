package com.codesquad.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSplitterTest {
    private CustomSplitter splitter;

    @Before
    public void setup() {
        splitter = new CustomSplitter();
    }

    @Test
    public void 커스텀세미콜론지원() {
        boolean canSupport = splitter.supports("//;\n1;2;3");
        assertThat(canSupport).isTrue();
    }

    @Test
    public void 커스텀문자열느낌표() {
        boolean canSupport = splitter.supports("//!\n3!4!5");
        assertThat(canSupport).isTrue();
    }

    @Test
    public void 커스텀문자열_세미콜론() {
        String[] split = splitter.split("//;\n1;2;3");
        assertThat(split).containsExactly("1", "2", "3");
    }

    @Test
    public void 커스텀문자열_느낌표() {
        String[] split = splitter.split("//!\n3!4!5");
        assertThat(split).containsExactly("3","4","5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 커스텀문자열_지원하지않는식() {
        splitter.split("3!4!5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 커스텀문자열_잘못된구분자() {
        splitter.split("//;\n3!4!5");
    }
}
