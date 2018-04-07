package com.codesquad.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultSplitterTest {

    private DefaultSplitter splitter;

    @Before
    public void setUp() {
        splitter = new DefaultSplitter();
    }

    @Test
    public void 콤마지원() {
        boolean canSupport = splitter.supports("1,2");
        assertThat(canSupport).isTrue();
    }

    @Test
    public void 단일항지원() {
         boolean canSupport = splitter.supports("5");
         assertThat(canSupport).isTrue();
    }

    @Test
    public void 콜론지원() {
        boolean canSupport = splitter.supports("2:3");
        assertThat(canSupport).isTrue();
    }

    @Test
    public void 다른특수문자지원() {
        boolean canSupport = splitter.supports("2!3");
        assertThat(canSupport).isFalse();
    }

    @Test
    public void 세개이상지원() {
        boolean canSupport = splitter.supports("1,2:3");
        assertThat(canSupport).isTrue();
    }

    @Test
    public void 콤마분해() {
        String[] split = splitter.split("1,2");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    public void 콜론분해() {
        String[] split = splitter.split("2:3");
        assertThat(split).containsExactly("2", "3");
    }

    @Test
    public void 콤마콜론분해() {
        String[] split = splitter.split("2:3,5");
        assertThat(split).containsExactly("2", "3", "5");
    }

    @Test
    public void 느낌표분해() {
        String[] split = splitter.split("2!3");
        assertThat(split).doesNotContain("2", "3");
    }
}