import model.Customer;
import model.Lotto;
import model.Rank;
import model.WinningLotto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @Before
    public void setUp(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        winningLotto = new WinningLotto(lotto, 9);
    }

    @Test
    public void compare(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertThat(winningLotto.compare(lotto)).isEqualTo(Rank.FIRST);
    }
}
