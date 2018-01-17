package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BuyInfoTest {
    private Lottos testLottos;
    @Before
    public void init() {
        testLottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                        new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9))
                )
        );
    }
    @Test
    public void buyInfoTest() {
        BuyInfo buyInfo = new BuyInfo(1000, testLottos);
    }
}
