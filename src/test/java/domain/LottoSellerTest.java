package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {

    private LottoSeller seller;

    @Before
    public void setUp() throws Exception {
        seller = new LottoSeller();
    }

    @Test
    public void buyLottos_정상파라미터() throws Exception {
        Optional<Lottos> lottos = seller.buyRandomNumberLottos(12000);
        assertThat(lottos.isPresent()).isTrue();
        assertThat(lottos.get().size()).isEqualTo(12);

        lottos = seller.buyRandomNumberLottos(11999);
        assertThat(lottos.isPresent()).isTrue();
        assertThat(lottos.get().size()).isEqualTo(11);
    }

    @Test
    public void buyLottos_1000원미만() throws Exception {
        assertThat(seller.buyRandomNumberLottos(999).isPresent()).isFalse();
    }

    @Test
    public void buyLottos_음수() throws Exception {
        assertThat(seller.buyRandomNumberLottos(-1000).isPresent()).isFalse();
    }

}
