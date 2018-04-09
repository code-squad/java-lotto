package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class StoreTest {
    @Test
    public void 돈_1000원_지급시_로또_1장_발급() {
        assertThat(LottoStore.pay(1000)).isNotEmpty().hasSize(1);
    }

    @Test
    public void 돈_14000원_지급시_로또_14장_발급() {
        assertThat(LottoStore.pay(14000)).isNotEmpty().hasSize(14);
    }

    @Test(expected = RuntimeException.class)
    public void 돈_1000원_이하_RuntimeException메소드() {
        LottoStore.pay(100);
    }
}
