package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void countMatchNumbers테스트() {
        assertThat(lotto.countMatchNumbers(new Numbers(1, 2, 3, 6, 7, 8))).isEqualTo(4);
    }
}
