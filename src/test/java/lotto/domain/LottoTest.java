package lotto.domain;

import org.junit.Before;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto(1, 2, 3, 4, 5, 6);
    }
}
