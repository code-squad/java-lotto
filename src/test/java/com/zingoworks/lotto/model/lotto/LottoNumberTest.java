package com.zingoworks.lotto.model.lotto;

import org.junit.Test;

public class LottoNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또넘버_유효범위() {
        LottoNumber.of(0);
        LottoNumber.of(46);
    }
}