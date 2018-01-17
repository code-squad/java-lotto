package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSellerTest {
    private BuyInfo buyInfo;
    @Before
    public void init() {
        buyInfo = new BuyInfo(5000, new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                        new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9))
                )
        ));
    }
    @Test
    public void lottoSellerTest() {
        LottoSeller lottoSeller = new LottoSeller(() -> Arrays.asList(1, 2, 3, 4, 5, 6));

        Lottos lottos = lottoSeller.buyLotto(buyInfo);

        assertThat(lottos.getNumOfLottos()).isEqualTo(5);
    }
}
