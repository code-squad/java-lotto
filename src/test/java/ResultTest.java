import lottoGame.domain.Lotto;
import lottoGame.dto.Result;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultTest {
    private List<Lotto> lottos = new ArrayList<>();

    @Before
    public void setup() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lotto.matchPoint(new Lotto(Arrays.asList(1,2,3,7,8,9)));
        lottos.add(lotto);
    }

    @Test
    public void 수익률_테스트() {
        assertEquals(5000 , Result.getAllProfit());
    }
}
