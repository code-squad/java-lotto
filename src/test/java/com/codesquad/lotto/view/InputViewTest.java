package com.codesquad.lotto.view;

import com.codesquad.lotto.vo.Money;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    public void 문자에서_돈변환() {
        final Money money = InputView.parseMoney("1000");
        assertThat(money).isEqualTo(new Money(1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자가_아님() {
        InputView.parseMoney("abc");
    }
}
