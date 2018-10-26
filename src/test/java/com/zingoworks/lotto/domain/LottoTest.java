package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.DuplicateLottoNumberException;
import com.zingoworks.lotto.exception.SizeOutOfBoundsException;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoTest {

    @Test
    public void 로또_getCountOfHit() {
        Lotto lotto = new ManualLotto("1,2,3,4,5,6");
        Lotto winningLotto = new ManualLotto("1,2,3,4,5,7");
        assertThat(lotto.getCountOfHit(winningLotto)).isEqualTo(5);
    }

    @Test
    public void 로또_contains() {
        Lotto lotto = new ManualLotto("1,2,3,4,5,6");
        assertThat(lotto.contains(6));
    }

    @Test (expected = DuplicateLottoNumberException.class)
    public void 수동로또_중복유무() {
        Lotto manualLotto = new ManualLotto("1,1,2,3,4,5");
    }

    @Test (expected = SizeOutOfBoundsException.class)
    public void 수동로또_크기() {
        Lotto manualLotto = new ManualLotto("1,13");
    }

    @Test (expected = IllegalArgumentException.class)
    public void 수동로또_유효범위() {
        Lotto manualLotto = new ManualLotto("0,1,2,3,4,5");
    }
}