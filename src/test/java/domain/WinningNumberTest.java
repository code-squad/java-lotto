package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningNumberTest {
    @Test
    public void winnigLottoTest() {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumber.getWinningLottos()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumber.getBonusNum()).isEqualTo(7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_null_case() {
        new WinningNumber(null, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_not_enough_case() {
        new WinningNumber(Arrays.asList(1, 2, 3, 4, 5), 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_negative_case() {
        new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), -1);
    }
}
