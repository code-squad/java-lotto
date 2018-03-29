package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoUtilTest {

    @Test
    public void 로또갯수반환() {
        assertThat(14, is(LottoUtil.getNumOfLotto(14000)));
    }

    @Test
    public void 랜덤값리스트생성() {
        assertThat(6, is(LottoUtil.getRandNumbers().size()));
    }

}
