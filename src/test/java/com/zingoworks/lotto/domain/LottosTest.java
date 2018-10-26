package com.zingoworks.lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottosTest {

    @Test (expected = IllegalArgumentException.class)
    public void 모든로또_최소구매금액() {
        new Lottos(999);
    }

    @Test
    public void 모든로또_구매로또개수() {
        Lottos lottos = new Lottos(5000);
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}