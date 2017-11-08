package lotto.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import lotto.model.MatchingResults.Match;

public class UserLottoTest {
    @Test
    public void match() throws Exception {
        UserLotto userLotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        Match match4 = userLotto.countOfMatch(winningLotto);
        assertEquals(Match.MATCH4, match4);
    }
}
