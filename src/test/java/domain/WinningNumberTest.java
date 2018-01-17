package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningNumberTest {
    @Test
    public void winnigLottoTest() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNo(7)
        );
        assertThat(winningNumber.getWinningLottos()).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(winningNumber.getBonusNum()).isEqualTo(new LottoNo(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_null_case() {
        new WinningNumber(null, new LottoNo(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_null_case2() {
        new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                null
        );
    }
}
