package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoProvider;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class LottoProviderTest {

    @Test
    public void 로또_구입() {
        LottoTicket lottoTicket = LottoProvider.order(new Money(5000));

        assertThat(lottoTicket.getQuantity()).isEqualTo(5);
    }

    @Test
    public void 로또_수동구입() {
        Money money = new Money(5000);

        List<Lotto> customLottos = new ArrayList();
        customLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        customLottos.add(new Lotto(Arrays.asList(12, 13, 14, 15, 16, 17)));

        LottoTicket lottoTicket = LottoProvider.order(money, customLottos);

        assertThat(lottoTicket.getQuantity()).isEqualTo(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_수동구입_돈이_부족할때() {
        Money money = new Money(1000);

        List<Lotto> customLottos = new ArrayList();
        customLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        customLottos.add(new Lotto(Arrays.asList(12, 13, 14, 15, 16, 17)));

        LottoProvider.order(money, customLottos);
    }
}
