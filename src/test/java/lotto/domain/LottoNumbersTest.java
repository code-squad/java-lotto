package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    private LottoNumbers numbers;

    @Before
    public void setUp() throws Exception {
        numbers = new LottoNumbers(1, 3, 5, 14, 22, 45);
    }

    @Test
    public void contains테스트() {
        assertThat(new LottoNumbers(1, 2, 3, 4, 5, 6)
                .contains(new LottoNumber(1)))
                .isEqualTo(true);
    }
}
