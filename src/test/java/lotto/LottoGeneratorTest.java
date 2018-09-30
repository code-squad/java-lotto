package lotto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {
    @Test
    public void 자동생성() {
        Lottos lottos = LottoGenerator.buyAutomatic(10);
        assertThat(lottos.getLottosCount()).isEqualTo(10);
    }

    @Test
    public void 수동생성() {
        String str[] = {"1, 2, 3, 4, 5, 6", "6, 7, 8, 9, 10, 11"};
        Lottos lottos = LottoGenerator.buyManually(str);
        assertThat(lottos.getLottosCount()).isEqualTo(2);
    }

}
