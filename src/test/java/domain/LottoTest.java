package domain;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoTest {
    @Test
    public void create(){
        LottoBundleFactory lf = new AutoLottoBundleFactory();
        Lotto lotto = lf.generate(1).getALotto(0);
        System.out.println(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void boundaryException(){
        LottoBundleFactory manual = new ManualLottoBundleFactory(Arrays.asList("0,1,2,3,4,5"));
        manual.generate(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void boundaryException2(){
        LottoBundleFactory manual = new ManualLottoBundleFactory(Arrays.asList("1,2,3,4,5,46"));
        manual.generate(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lengthException(){
        LottoBundleFactory manual = new ManualLottoBundleFactory(Arrays.asList("1,2,3,4,5,6,7"));
        manual.generate(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bothException(){
        LottoBundleFactory manual = new ManualLottoBundleFactory(Arrays.asList("0,1,2,3,4,5,47"));
        manual.generate(1);
    }

    @Test
    public void calculateHitCount(){
        LottoBundleFactory manual = new ManualLottoBundleFactory(Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6"));
        LottoBundle lb = manual.generate(2);

        assertThat(lb.getALotto(0).calculateHitCount(lb.getALotto(1))).isEqualTo(6);

        LottoBundleFactory manual2 = new ManualLottoBundleFactory(Arrays.asList("1, 2, 3, 43, 44, 45"));
        Lotto lottoC = manual2.generate(1).getALotto(0);

        assertThat(lb.getALotto(0).calculateHitCount(lottoC)).isEqualTo(3);
        assertThat(lottoC.calculateHitCount(lb.getALotto(0))).isEqualTo(3);
    }







}
