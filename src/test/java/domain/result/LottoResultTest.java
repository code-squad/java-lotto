package domain.result;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoResultTest {
    private LottoResult result;

    @Before
    public void setUp() throws Exception {
        Rank rank = Rank.of(true);
        result = new LottoResult(rank);
    }

    @Test
    public void 비교하고자하는_랭크와_같냐() {
        assertTrue(result.isSameRank(Rank.SECOND));
    }

    @Test
    public void 상금() {
        assertEquals(Rank.SECOND.getPrize(), result.getPrizeMoney());
    }

    @Test
    public void 비교하고자하는_랭크와_다르냐() {
        assertFalse(result.isSameRank(Rank.FIRST));
    }
}