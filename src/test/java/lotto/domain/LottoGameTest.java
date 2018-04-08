package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LottoGameTest {
    @Test
    public void 구입금액_만큼_로또_티켓을_얻는다() {
        Assertions.assertThat(LottoGame.buyTicket(14000)).hasSize(14);
    }
}
