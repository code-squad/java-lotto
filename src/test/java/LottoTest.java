import model.Lotto;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void matchCount(){
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(7, 8, 9, 1, 4, 6));
        assertThat(lotto.matchCount(winningLotto)).isEqualTo(3);
    }

    @Test
    public void isMatchBonus(){
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isMatchBonus(9)).isFalse();
    }
}
