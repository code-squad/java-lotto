package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class LottoStoreTest {
    @Test
    public void buy_lotto_돈_1000원_로또_1장구매() {
        assertThat(LottoStore.buyLotto(1000)).hasSize(1).isInstanceOf(List.class);
    }

    @Test
    public void buy_lotto_돈_14000원_로또_14장구매() {
        assertThat(LottoStore.buyLotto(14000)).hasSize(14).isInstanceOf(List.class);
    }

    @Test(expected = RuntimeException.class)
    public void 돈_1000원_이하_RuntimeException메소드() {
        LottoStore.buyLotto(100);
    }


    @Test
    public void 로또가게에서_5000원으로_수동_3장과_자동_2장_구매() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(LottoStore.buyLotto(5_000, lottos)).hasSize(5);
    }

    @Test
    public void 로또가게에서_3000원으로_수동_3구매() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(LottoStore.buyLotto(3_000, lottos)).hasSize(3);
    }
}
