import lottoGame.domain.Lotto;
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

    @Before
    public void setup(){
        Lotto lastWeekNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        allMatch = new Lotto(Arrays.asList(1,2,3,4,5,6));
        allMatch.matchPoint(lastWeekNumbers);

        threeMatch = new Lotto(Arrays.asList(1,2,3,9,10,11));
        threeMatch.matchPoint(lastWeekNumbers);

        fourMatch = new Lotto(Arrays.asList(1,2,3,4,7,8));
        fourMatch.matchPoint(lastWeekNumbers);

        fiveMatch = new Lotto(Arrays.asList(1,2,3,4,5,9));
        fiveMatch.matchPoint(lastWeekNumbers);
    }

    @Test
    public void 당첨_금액_테스트() {
        assertEquals(5000, threeMatch.profit());

        assertEquals(50000, fourMatch.profit());

        assertEquals(1500000, fiveMatch.profit());

        assertEquals(2000000000, allMatch.profit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_생성_테스트 () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        new Lotto(numbers);
    }
}
