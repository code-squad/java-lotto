import LottoGame.Rank;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 11..
 */
public class RankTest {
    /**
     * 테스트 케이스 정리
     * 1. 일치하는수를 로또 등수로 변경
     * 2. 로또 2등
     * 3. 로또 3등
     */

    @Test
    public void 일치하는수를로또등수로변경() {
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
    }

    @Test
    public void 로또2등() {
        assertEquals(Rank.SECOND, Rank.getRank(Rank.SECOND, true));
    }

    @Test
    public void 로또3등(){
        assertEquals(Rank.THIRD, Rank.getRank(Rank.SECOND, false));
    }

}