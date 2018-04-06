import org.junit.Test;
import rank.Rank;
import result.Result;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ResultTest {
    @Test
    public void 벌어들인돈() {
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FIFTH, Rank.FOURTH, Rank.NONE, Rank.NONE);
        Result result = new Result(ranks);
        assertEquals(60000, result.earn(ranks));
    }

    @Test
    public void 수익률() {
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FIFTH, Rank.FOURTH, Rank.NONE, Rank.NONE);
        Result result = new Result(ranks);
        assertEquals(1200, result.getPercent());
    }
}
