package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoUtilTest {

    @Test
    public void 랜덤값리스트생성_길이비교() {
        assertThat(6, is(LottoUtil.getRandNumbers().size()));
    }

    @Test
    public void 입력돈유효성체크반환() {
        assertThat(3000, is(LottoUtil.checkReturnInputMoney(3000)));
    }

    @Test(expected = RuntimeException.class)
    public void 입력돈유효성체크반환_exception() {
        LottoUtil.checkReturnInputMoney(-1);
    }

    @Test
    public void 입력돈유효성체크_true() {
        assertThat(true, is(LottoUtil.validInputMoney(3000)));
    }

    @Test
    public void 입력돈유효성체크_false() {
        assertThat(false, is(LottoUtil.validInputMoney(-1)));
    }
}
