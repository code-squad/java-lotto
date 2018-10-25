package com.zingoworks.lotto.domain;

import org.junit.Test;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoTest {


    @Test (expected = Exception.class)
    public void 로또_중복유무() {
        assertThat(Lotto.generateAutomaticLotto().getLottoNumbers().size())
                .isEqualTo(new HashSet(Lotto.generateAutomaticLotto().getLottoNumbers()).size());
        Lotto duplicatedLotto = Lotto.generateManualLotto("1,1,2,3,4,5");
    }

    @Test
    public void 로또_기본숫자세트_크기() {
        assertThat(Lotto.generateAutomaticLotto().getBasicNumberSet().size()).isEqualTo(45);
    }

    @Test
    public void 로또_적중개수() {
        Lotto lotto = Lotto.generateManualLotto("1,2,3,4,5,6");
        Lotto winningLotto = Lotto.generateManualLotto("1,2,3,4,5,7");
        assertThat(lotto.getCountOfHit(winningLotto)).isEqualTo(5);
    }

    @Test
    public void 로또_오름차순정렬확인() {
        assertThat(Lotto.generateManualLotto("1,2,3") == Lotto.generateManualLotto("3,2,1"));
    }
}