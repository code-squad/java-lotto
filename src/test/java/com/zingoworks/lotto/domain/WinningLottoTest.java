package com.zingoworks.lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class WinningLottoTest {

    @Test
    public void 정답로또_등수() {
        WinningLotto w = new WinningLotto("1,2,3,4,5,6", 7);
        Lotto u = new ManualLotto("1,2,3,4,5,6");
        assertThat(w.match(u)).isEqualTo(Prize.FIRST);
    }
}