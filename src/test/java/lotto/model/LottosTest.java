package lotto.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lotto.model.Result.MatchingResult;

public class LottosTest {

    @Test
    public void match() {
        List<UserLotto> userLottos = new ArrayList<>();
        userLottos.add(new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        userLottos.add(new UserLotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        userLottos.add(new UserLotto(Arrays.asList(9, 10, 11, 12, 13, 14)));
        userLottos.add(new UserLotto(Arrays.asList(9, 10, 15, 16, 17, 18)));
        
        Lottos lottos = new Lottos(userLottos);
        WinningLotto lotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        Result result = lottos.match(lotto);
        List<MatchingResult> matchingResult = result.getResults();
        
        assertEquals(4, result.getCountOfLotto());
        assertEquals(0, matchingResult.get(0).getCountOfMatchingLotto());
        assertEquals(1, matchingResult.get(1).getCountOfMatchingLotto());
        assertEquals(0, matchingResult.get(2).getCountOfMatchingLotto());
        assertEquals(1, matchingResult.get(3).getCountOfMatchingLotto());
    }
}
