package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {

    private LottoSeller seller;

    @Before
    public void setUp() throws Exception {
        seller = new LottoSeller();
    }

    @Test
    public void buyRandomLottos_정상파라미터() throws Exception {
        Optional<Lottos> lottos = seller.buyRandomLottos(12000);
        assertThat(lottos.isPresent()).isTrue();
        assertThat(lottos.get().size()).isEqualTo(12);

        lottos = seller.buyRandomLottos(11999);
        assertThat(lottos.isPresent()).isTrue();
        assertThat(lottos.get().size()).isEqualTo(11);
    }

    @Test
    public void buyRandomLottos_1000원미만() throws Exception {
        assertThat(seller.buyRandomLottos(999).isPresent()).isFalse();
    }

    @Test
    public void buyRandomLottos_음수() throws Exception {
        assertThat(seller.buyRandomLottos(-1000).isPresent()).isFalse();
    }

    @Test
    public void buyRandomLottosWithManualLottos() throws Exception {
        Lottos manualLottos = new Lottos(Arrays.asList(new Lotto(1, 2, 3, 4, 5, 6),
                                                       new Lotto(1, 2, 3, 4, 5, 6)));
        Lottos lottos = seller.buyRandomLottosWithManualLottos(10000, manualLottos);

        assertThat(lottos.size()).isEqualTo(10);
    }

    @Test
    public void buyRandomLottosWithManualLottos_인자가널인경우() throws Exception {
        Lottos lottos = seller.buyRandomLottosWithManualLottos(10000, null);

        assertThat(lottos.size()).isEqualTo(10);
    }

}
