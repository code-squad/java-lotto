package domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoFactoryTest {

    @Test
    public void makeRandNumber() {
        List<Integer> randNumber = LottoFactory.makeRandNumber();
        assertThat(randNumber.size()).isEqualTo(45);
    }

    @Test
    public void makeLottoNumber() {
        List<Integer> lottoNumber = LottoFactory.makeLottoNumber();
        assertThat(lottoNumber.size()).isEqualTo(6);
    }
}
