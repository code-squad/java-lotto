import model.Lotto;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto(46, 6);
    }

    @Test
    public void generateTest() {
        assertThat(lotto.getNumbers().size()).isEqualTo((int)(lotto.getNumbers().stream().distinct().count()));
    }
}
