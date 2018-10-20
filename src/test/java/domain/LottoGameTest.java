package domain;
import domaim.LottoGame;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void countGameNum() {
        assertThat(new LottoGame().countGameNum(19000)).isEqualTo(19);
    }
}
