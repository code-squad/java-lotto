package model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class LottoTest {
    private Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto(14000);
    }

    @Test
    public void countOfLotto() {
        assertThat(lotto.countOfLotto()).isEqualTo(14);
    }
}
