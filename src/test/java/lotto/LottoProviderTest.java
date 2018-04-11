package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoProvider;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class LottoProviderTest {

    @Test
    public void 로또_구입() {
        LottoTicket lottoGame = LottoProvider.order(5000);
        assertThat(lottoGame.getQuantity()).isEqualTo(5);
    }
}
