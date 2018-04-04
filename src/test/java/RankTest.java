import org.junit.Test;
import rank.Rank;
import result.Result;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RankTest {
    @Test
    public void FIFTH랭크테스트() {
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
    }

    @Test
    public void THIRD랭크테스트() {
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
    }

    @Test
    public void SECOND랭크테스트() {
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
    }

    @Test
    public void FIRST랭크테스트() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
    }

    @Test
    public void THIRD미만테스트() {
        assertEquals(Rank.NONE, Rank.valueOf(2, false));
    }

    @Test
    public void 랭크에서맞춘갯수출력() {
        List<Rank> ranks = Arrays.asList(Rank.FOURTH, Rank.FOURTH, Rank.NONE, Rank.FIFTH, Rank.SECOND);
        Result result = new Result();
        result.insert(ranks);
        int num1 = Result.finalResult.get(Rank.FOURTH);
        int num2 = Result.finalResult.get(Rank.FIFTH);
        int num3 = Result.finalResult.get(Rank.SECOND);
        int num4 = Result.finalResult.get(Rank.THIRD);
        assertEquals(2, num1);
        assertEquals(1, num2);
        assertEquals(1, num3);
        assertEquals(0, num4);
    }
}
