import DTO.WinningLotto;
import model.Lotto;
import model.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private WinningLotto winningLotto;
    private Lotto lotto;
    private Rank rank;

    @Before
    public void setUp(){
        lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        rank = Rank.valueOf(6, false);
    }

    @Test
    public void putWinningLotto(){
        Map<Lotto, Rank> expectResult = new HashMap();
        expectResult.put(lotto, rank);

        assertThat(winningLotto.putWinningLotto(lotto, rank)).isEqualTo(expectResult);
    }
}
