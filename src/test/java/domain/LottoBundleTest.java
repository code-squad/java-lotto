package domain;

import java.util.*;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {
    @Test
    public void add(){
        List<String> lottoTexts = new ArrayList<>();
        LottoBundle theLottoBundle = LottoFactory.generateLottoBundle(0, lottoTexts);
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto theLotto = LottoFactory.generateTheLotto(set);
        theLottoBundle.add(theLotto);
        assertThat(theLottoBundle.getALotto(0)).isEqualTo(theLotto);
    }
}
