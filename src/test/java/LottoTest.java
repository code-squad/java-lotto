import domain.Lotto;
import domain.WinningLotto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    Lotto lottos;

    @Before
    public void setup(){
        lottos = new Lotto(Arrays.asList(1,3,13,24,4,5));
    }
    @Test
    public void matchYn() {
        assertThat(lottos.matchYn(3)).isEqualTo(1);
    }
    @Test
    public void countMatchLotto() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,3,4,5,6,7),14);
        assertThat(lottos.countMatchLotto(winningLotto)).isEqualTo(4);
    }
}
