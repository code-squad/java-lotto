package com.zingoworks.lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class LottosTest {

    @Test (expected = IllegalArgumentException.class)
    public void 모든로또_최소구매금액() {
        List<String> none = new ArrayList<>();
        new Lottos(999, none);
    }

    @Test
    public void 모든로또_구매로또개수() {
        List<String> none = new ArrayList<>();
        Lottos lottos = new Lottos(5000, none);
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}