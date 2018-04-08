package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningTier;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class LottoTest {

    @Test
    public void 당첨숫자_비교() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int count = lotto.compareWithWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(count).isEqualTo(WinningTier.FIRST.getEqualNumbersCount());
    }
}
