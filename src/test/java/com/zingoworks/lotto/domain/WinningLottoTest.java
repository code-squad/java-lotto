package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.DuplicateLottoNumberException;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {

//    @Test
//    public void 로또정답_개수확인() {
//        Lotto lotto = Lotto.generateManualLotto("1,2,3,4,5,6");
//        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);
//        assertThat(lotto.getCountOfHit(winningLotto.getWinningLotto())).isEqualTo(6);
//    }

    @Test (expected = IllegalArgumentException.class)
    public void 로또정답_유효범위() {
        WinningLotto winningLotto = new WinningLotto("0,2,3,4,5,6", 7);
    }

//    @Test
//    public void 로또정답_보너스볼확인() {
//        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);
//        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
//    }

    @Test (expected = IllegalArgumentException.class)
    public void 보너스볼_유효범위() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 0);
    }

    @Test (expected = DuplicateLottoNumberException.class)
    public void 보너스볼_중복() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 6);
    }
}