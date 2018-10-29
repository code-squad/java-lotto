package domain;

import java.util.*;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {
    @Test
    public void add(){
        List<String> lottoTexts = new ArrayList<>();
        LottoBundleFactory auto = new AutoLottoBundleFactory();
        LottoBundleFactory manual = new ManualLottoBundleFactory(Arrays.asList("1,2,3,4,5,6"));

        LottoBundle theLottoBundle = manual.generate(1).addAll(auto.generate(10));
        Lotto theLotto = manual.generate(1).getALotto(0);
        assertThat(theLottoBundle.getALotto(0)).isEqualTo(theLotto);
    }
}
