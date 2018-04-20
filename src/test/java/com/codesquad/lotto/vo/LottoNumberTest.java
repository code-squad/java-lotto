package com.codesquad.lotto.vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void 최소값_생성() {
        LottoNumber.of(LottoNumber.MIN_NUMBER);
    }

    @Test
    public void 최대값_생성() {
        LottoNumber.of(LottoNumber.MAX_NUMBER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최소값보다_작은_생성() {
        LottoNumber.of(LottoNumber.MIN_NUMBER - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최대값보다_큰_생성() {
        LottoNumber.of(LottoNumber.MAX_NUMBER + 1);
    }

    @Test
    public void 숫자1생성() {
        final LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
    }

    @Test
    public void 숫자45생성() {
        final LottoNumber lottoNumber = LottoNumber.of(45);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(45));
    }

    @Test
    public void fromInteger() {
        final LottoNumber number = LottoNumber.of(5);
        assertThat(number).isEqualTo(LottoNumber.of(5));
    }

    @Test
    public void fromString() {
        final LottoNumber number = LottoNumber.from("6");
        assertThat(number).isEqualTo(LottoNumber.of(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자가아닌문자() {
        LottoNumber.from("!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 널입력() {
        final LottoNumber number = LottoNumber.from(null);
    }

    @Test
    public void 값10가져오기() {
        final LottoNumber number = LottoNumber.of(10);
        final int value = number.getValue();
        assertThat(value).isEqualTo(10);
    }
}
