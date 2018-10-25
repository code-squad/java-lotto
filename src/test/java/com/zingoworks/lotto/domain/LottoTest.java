package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.DuplicateLottoNumberException;
import com.zingoworks.lotto.exception.SizeOutOfBoundsException;
import org.junit.Test;

import static com.zingoworks.lotto.domain.Lotto.BASIC_NUMBERS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoTest {

    @Test
    public void 로또_기본숫자세트_크기() {
        assertThat(BASIC_NUMBERS.size()).isEqualTo(45);
    }

    @Test
    public void 로또_적중개수() {
        Lotto lotto = Lotto.generateManualLotto("1,2,3,4,5,6");
        Lotto winningLotto = Lotto.generateManualLotto("1,2,3,4,5,7");
        assertThat(lotto.getCountOfHit(winningLotto)).isEqualTo(5);
    }

    @Test
    public void 로또_오름차순정렬확인() {
        System.out.println(Lotto.generateAutomaticLotto());
        System.out.println(Lotto.generateAutomaticLotto());
        System.out.println(Lotto.generateAutomaticLotto());
        assertThat(Lotto.generateManualLotto("1,2,3") == Lotto.generateManualLotto("3,2,1"));
    }

    @Test
    public void 로또_임의의숫자를포함하는가() {
        Lotto lotto = Lotto.generateManualLotto("1,2,3,4,5,6");
        assertThat(lotto.contains(6));
    }



    @Test (expected = DuplicateLottoNumberException.class)
    public void 수동로또_중복유무() {
        Lotto manualLotto = Lotto.generateManualLotto("1,1,2,3,4,5,6");
    }

    @Test (expected = SizeOutOfBoundsException.class)
    public void 수동로또_크기() {
        Lotto manualLotto = Lotto.generateManualLotto("1,13");
    }

    @Test (expected = IllegalArgumentException.class)
    public void 수동로또_유효범위() {
        Lotto manualLotto = Lotto.generateManualLotto("0,13");
    }



}