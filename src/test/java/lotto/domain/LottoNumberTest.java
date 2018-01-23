package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumberTest {

    @Test
    public void create() {
        LottoNumber no = new LottoNumber(1);
        System.out.println(no);

        assertThat(new LottoNumber(1)).isEqualTo(no);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_체크_최대값(){
        new LottoNumber(50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_체크_최소값(){
        new LottoNumber(0);
    }

}