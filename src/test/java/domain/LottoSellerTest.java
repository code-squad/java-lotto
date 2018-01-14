package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {

    private LottoSeller seller;

    @Before
    public void setUp() throws Exception {
        seller = new LottoSeller();
    }

    @Test
    public void buyLottos_정상파라미터() throws Exception {
        Lottos lottos = seller.buyRandomNumberLottos(12000);
        assertThat(lottos.size()).isEqualTo(12);

        lottos = seller.buyRandomNumberLottos(11999);
        assertThat(lottos.size()).isEqualTo(11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buyLottos_1000원미만() throws Exception {
        seller.buyRandomNumberLottos(999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buyLottos_음수() throws Exception {
        seller.buyRandomNumberLottos(-1000);
    }

}
