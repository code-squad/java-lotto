package com.codesquad.lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinTypeTest {
    @Test
    public void 일치3개() {
        assertThat(WinType.THREE.toString()).isEqualTo("3개 일치 (5000원)");
    }

    @Test
    public void 일치6개() {
        assertThat(WinType.SIX.toString()).isEqualTo("6개 일치 (2000000000원)");
    }

    @Test
    public void 일치3에서_enum으로() {
        final WinType type = WinType.valueOf(3);
        assertThat(type).isEqualTo(WinType.THREE);
    }

    @Test
    public void 일치6에서_enum으로() {
        final WinType type = WinType.valueOf(6);
        assertThat(type).isEqualTo(WinType.SIX);
    }

    @Test
    public void 일치0개면() {
        final WinType type = WinType.valueOf(0);
        assertThat(type).isEqualTo(WinType.OUT);
    }

    @Test
    public void 일치2개면() {
        final WinType type = WinType.valueOf(2);
        assertThat(type).isEqualTo(WinType.OUT);
    }

    @Test
    public void 일치3개_당첨1개_상금() {
        final Money prize = WinType.THREE.calculatePrize(1);
        assertThat(prize).isEqualTo(new Money(5000));
    }

    @Test
    public void 일치3개_당첨2개_상금() {
        final Money prize = WinType.THREE.calculatePrize(2);
        assertThat(prize).isEqualTo(new Money(10000));
    }

    @Test
    public void 일치4개_당첨2개_상금() {
        final Money prize = WinType.FOUR.calculatePrize(2);
        assertThat(prize).isEqualTo(new Money(100000));
    }

    @Test
    public void 당첨_참() {
        final WinType type = WinType.SIX;
        final boolean isWin = type.isWin();
        assertThat(isWin).isTrue();
    }

    @Test
    public void 당첨_거짓() {
        final WinType type = WinType.OUT;
        final boolean isWin = type.isWin();
        assertThat(isWin).isFalse();
    }
}
