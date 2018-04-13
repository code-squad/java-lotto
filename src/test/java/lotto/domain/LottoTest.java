package lotto.domain;

import org.junit.Before;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6), false);
    }
}
