package model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 중복되지_않는_여섯개의_숫자() {
        Lotto lotto = new Lotto();
        String[] tests = lotto.toString().substring(1).split("(, )|\\]");
        assertThat(tests).hasSize(6);
    }
}
