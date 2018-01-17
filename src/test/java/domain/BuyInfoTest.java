package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BuyInfoTest {
    private BuyInfo buyInfo;
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

        buyInfo = new BuyInfo(5000, testLottos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest() {
        new BuyInfo(1000, testLottos);
    }

    @Test
    public void getNumOfAutoLotto() {
        assertThat(buyInfo.getBuyableNumberOfAutoLottos()).isEqualTo(1);
    }

    @Test
    public void joinLottosTest() {
        assertThat(buyInfo.joinLottos(testLottos)).isEqualTo(9);
    }
}
