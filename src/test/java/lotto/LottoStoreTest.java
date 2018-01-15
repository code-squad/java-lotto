package lotto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LottoStoreTest {

    private LottoStore lottoStore;

    @Before
    public void setUp() throws Exception {
        lottoStore = new LottoStore(10000);
    }

    @Test
    public void 로또_생성_test(){
        lottoStore = new LottoStore(10000);
        assertThat(lottoStore.getLottos().size()).isEqualTo(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_생성_1000으로_나뉘지_않는_금액_이거나_int_값_보다_큰_수(){
        lottoStore = new LottoStore(1200);
        lottoStore = new LottoStore(1000000000);
    }

    @Test
    public void getCount(){
        assertThat(lottoStore.getCount()).isEqualTo(10);
    }



}
