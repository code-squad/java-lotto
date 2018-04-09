package lotto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    LottoMachine lotto;

    @Before
    public void setup() {
        lotto = new LottoMachine();
    }

    @Test
    public void 로또_구매() {
        int result = lotto.getCountOfLotto(13000);
        assertThat(result).isEqualTo(13);
    }
}
