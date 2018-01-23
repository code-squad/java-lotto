package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    public void create(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        System.out.println(lotto);

        assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6))).isEqualTo(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_당첨번호_5개전달() {
        new Lotto(Arrays.asList(1,2,3,4,5));

    }

    @Test
    public void contains() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertThat(lotto.contains(new LottoNumber(1))).isTrue();
        assertThat(lotto.contains(new LottoNumber(7))).isFalse();
    }
}