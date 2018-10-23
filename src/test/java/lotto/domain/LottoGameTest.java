package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void 생성자() {
        LottoGame lg = new LottoGame(2000);
        assertThat(lg.getLottos().size()).isEqualTo(2);
    }
}
