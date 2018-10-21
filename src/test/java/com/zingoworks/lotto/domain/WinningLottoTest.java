package com.zingoworks.lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {

    @Test
    public void 로또정답_개수확인() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);
        assertThat(winningLotto.getWinningNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 로또정답_보너스볼확인() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}