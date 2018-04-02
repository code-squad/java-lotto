package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoUtilTest {

    @Test
    public void countSameRank() {
        List<Rank> ranks = Arrays.asList(Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.SECOND, Rank.THIRD);
        assertThat(LottoUtils.countSameRank(ranks, Rank.FIRST), is(3));
    }

    @Test
    public void rankToInteger() {
        List<Rank> ranks = Arrays.asList(Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.SECOND, Rank.THIRD);
        List<Integer> ints = Arrays.asList(3, 1, 1, 0, 0);
        assertThat(LottoUtils.rankToInt(ranks), is(ints));
    }

    @Test
    public void 당첨금액계산() {
        List<Integer> prizeStatistics = Arrays.asList(0, 0, 0, 0, 1);
        assertThat(LottoUtils.calcTotalEarnings(prizeStatistics), is(5000));
    }

    @Test
    public void stringToIntParser() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(LottoUtils.stringToIntList(input), is(numbers));
    }

    @Test
    public void listToLottoNoGroup() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNo> lottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
        LottoNoGroup lottoNoGroup = LottoNoGroup.of(lottoNos);
        assertThat(LottoUtils.listToLottoNoGroup(numbers), is(lottoNoGroup));
    }

}
