package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Moonchan on 2018. 1. 17..
 */
public class WinningNumberTest {

    private LottoNumber number;

    @Before
    public void setup() {
        number = new LottoNumber(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    public void 정상생성() {
        WinningNumber winningNumber = new WinningNumber(number, 7);
        assertThat(winningNumber.getBonusNumber()).isEqualTo(7);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스숫자가_당첨숫자와_중복() {
        WinningNumber winningNumber = new WinningNumber(number, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스숫자가_범위를_벗어남() {
        WinningNumber winningNumber = new WinningNumber(number, 50);
    }
}