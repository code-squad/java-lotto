package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lotto.domain.LottoStore;
import org.junit.Before;
import org.junit.Test;

public class LottoStoreTest {

    private LottoStore lottoStore;
    private List<String> manualLotto;

    @Before
    public void setUp() {
        manualLotto = new ArrayList<>(Arrays.asList("1,2,3,4,5,6","3,4,5,6,7,8"));
        lottoStore = new LottoStore(10000, Optional.ofNullable(manualLotto));
    }

    @Test
    public void 로또_생성_test(){
        lottoStore = new LottoStore(10000, Optional.ofNullable(manualLotto));
        assertThat(lottoStore.getLottos().size()).isEqualTo(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_생성_1000으로_나뉘지_않는_금액_이거나_int_값_보다_큰_수(){
        lottoStore = new LottoStore(1200, Optional.ofNullable(manualLotto));
        lottoStore = new LottoStore(1000000000, Optional.ofNullable(manualLotto));
    }

}
