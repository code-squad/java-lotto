import org.junit.Test;
import profit.Profit;
import rank.Rank;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ProfitTest {
    @Test
    public void 벌어들인돈() {
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FIFTH, Rank.FOURTH, Rank.NONE, Rank.NONE);
        Profit profit = new Profit();
        assertEquals(60000, profit.earn(ranks));
    }

    @Test
    public void 수익률() {
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FIFTH, Rank.FOURTH, Rank.NONE, Rank.NONE);
        Profit profit = new Profit();
        assertEquals(1200, profit.percent(ranks));
    }
}
