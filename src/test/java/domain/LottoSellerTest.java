package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSellerTest {
    //금액을 넘기면 그에 해당하는 로또를 넘겨준다.
    @Test
    public void lottoSellerTest() {
        List<Lotto> lottos = LottoSeller.buyLotto(5000, () -> Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottos.size()).isEqualTo(5);
        for (int i = 0 ; i < 5 ; i++)
            assertThat(lottos.get(i).toString()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6).toString());
    }
}
