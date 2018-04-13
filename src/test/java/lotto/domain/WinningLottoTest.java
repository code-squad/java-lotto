package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 보너스_당첨() {
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        String bonusNumber = "10";
        Lotto bonusWinning = new Lotto(Arrays.asList("1", "2", "3", "4", "5", bonusNumber));

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Rank rank = winningLotto.match(bonusWinning);

        assertThat(rank)
                .isEqualTo(Rank.BONUS);
    }
}