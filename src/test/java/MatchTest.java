import LottoGame.Match;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 11..
 */
public class MatchTest {
    /**
     * 테스트 케이스 정리
     * 1. 매치된 숫자확인
     */

    @Test
    public void 매치된숫자확인() {
        assertEquals(Match.THREE, Match.ofMatch(3));
    }

}
