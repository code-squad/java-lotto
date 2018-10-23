package domain;

import java.util.Arrays;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {
    @Test
    public void add(){
        LottoBundle theLottoBundle = LottoFactory.generateRandomLottoBundle(0);
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto theLotto = LottoFactory.generateTheLotto(set);
        theLottoBundle.add(theLotto);
        assertThat(theLottoBundle.getALotto(0)).isEqualTo(theLotto);
    }
}
