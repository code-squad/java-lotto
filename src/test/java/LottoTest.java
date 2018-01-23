import lottoGame.domain.Lotto;
import lottoGame.domain.WinningLotto;
import lottoGame.enums.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoTest {

    private Lotto allMatch;
    private Lotto threeMatch;
    private Lotto fourMatch;
    private Lotto fiveMatch;
    private Lotto bonusMatch;

    @Before
    public void setup(){
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6),7);
        allMatch = new Lotto(Arrays.asList(1,2,3,4,5,6));
        allMatch.matchPoint(winningLotto);

        threeMatch = new Lotto(Arrays.asList(1,2,3,9,10,11));
        threeMatch.matchPoint(winningLotto);

        fourMatch = new Lotto(Arrays.asList(1,2,3,4,7,8));
        fourMatch.matchPoint(winningLotto);

        fiveMatch = new Lotto(Arrays.asList(2,3,4,5,6,9));
        fiveMatch.matchPoint(winningLotto);

        bonusMatch = new Lotto(Arrays.asList(1,2,3,4,5,7));
        bonusMatch.matchPoint(winningLotto);
    }

    @Test
    public void 당첨_랭킹_테스트() {
        assertEquals(Rank.FIFTH, threeMatch.lottoRank());

        assertEquals(Rank.FOURTH, fourMatch.lottoRank());

        assertEquals(Rank.THIRD, fiveMatch.lottoRank());

        assertEquals(Rank.FIRST, allMatch.lottoRank());

        assertEquals(Rank.SECOND, bonusMatch.lottoRank());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_생성_테스트 () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        new Lotto(numbers);
    }
}
