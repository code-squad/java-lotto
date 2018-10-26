package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;
import util.StringParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoFactoryTest {
    @Test
    public void generateLottoBundle() {
        List<String> list = new ArrayList<>();
        String s = "1,2,3,4,5,6";
        list.add(s);
        Lotto aLotto = LottoFactory.generateTheLotto(StringParser.parseToNumbers(s));
        LottoBundle theLottoBundle = LottoFactory.generateLottoBundle(10, list);
        assertThat(theLottoBundle.getALotto(0)).isEqualTo(aLotto);
    }

    @Test (expected = IllegalArgumentException.class)
    public void generateWinningLottoWithException() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        LottoFactory.generateWinningLotto(set, 5);
    }

    @Test
    public void generateWinningLotto(){
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        assertTrue(LottoFactory.generateWinningLotto(set, 7) instanceof WinningLotto);
    }
}
