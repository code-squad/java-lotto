package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoUtilTest {

    @Test
    public void 랜덤값리스트생성_길이비교() {
        assertThat(6, is(LottoUtil.getRandNumbers().size()));
    }

}
