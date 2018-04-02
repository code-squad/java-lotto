package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoUtilTest {

    @Test
    public void CountSameRank() {
        List<Rank> ranks = Arrays.asList(Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.SECOND, Rank.THIRD);
        assertThat(LottoUtils.countSameRank(ranks, Rank.FIRST), is(3));
    }

    @Test
    public void RankToInteger() {
        List<Rank> ranks = Arrays.asList(Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.SECOND, Rank.THIRD);
        List<Integer> ints = Arrays.asList(3, 1, 1, 0, 0);
        assertThat(LottoUtils.rankToInt(ranks), is(ints));
    }

    @Test
    public void 당첨금액계산() {
        List<Integer> prizeStatistics = Arrays.asList(0, 0, 0, 0, 1);
        assertThat(LottoUtils.calcTotalEarnings(prizeStatistics), is(5000));
    }
}
