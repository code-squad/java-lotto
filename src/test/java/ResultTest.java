import lottoGame.domain.Lotto;
import lottoGame.dto.Result;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultTest {
    private Result result;
    private List<Lotto> lottos = new ArrayList<>();

    @Before
    public void setup() {
        result = new Result();
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lotto.matchPoint(Arrays.asList(1,2,3,7,8,9));
        lottos.add(lotto);
        result.winnerResult(lottos);
    }
    @Test
    public void 수익률_테스트() {
        assertEquals(500,result.calcPrice(lottos));
    }
}
