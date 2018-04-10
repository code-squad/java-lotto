package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.List;

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
}
