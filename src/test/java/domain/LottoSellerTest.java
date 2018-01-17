package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSellerTest {
    //금액을 넘기면 그에 해당하는 로또를 넘겨준다.
    @Test
    public void lottoSellerTest() {
        LottoSeller lottoSeller = new LottoSeller(() -> Arrays.asList(1, 2, 3, 4, 5, 6));

        Lottos lottos = lottoSeller.buyLotto(5000);

        assertThat(lottos.getNumOfLottos()).isEqualTo(5);
    }
}
