package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 자동로또추출() {
        Lotto lotto = LottoGenerator.createLotto();
        System.out.println(lotto);
    }

    @Test
    public void 수동로또추출() {
        Lotto lotto = Lotto.ofManualLotto("1,2,3,4,5,6");
        for (int i = 0; i < lotto.size(); i++) {
            assertThat(lotto.getOneLotto(i)).isEqualTo(LottoNo.of(i+1));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또생성개수초과() {
        Lotto.ofManualLotto("1,2,3,4,5,6,7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또생성개수미달() {
        Lotto.ofManualLotto("1,2,3,4,5");
    }
}
