package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 입력한_금액만큼_로또_구매() {
        // given
        final int amount = 14_000;
        final int count = LottoGame.count(amount);

        // when
        List<Lotto> lotos = LottoGame.buy(count);

        // then
        assertThat(lotos)
                .hasSize(count);
    }

    @Test
    public void 당첨자() {
        // given
        LottoGame lottoGame = new LottoGame();
        final List<String> winningNumber = Arrays.asList("1", "2", "3", "4", "5", "6");
        String bonusNumber = "10";

        // when
        GameResult gameResult = lottoGame.play(winningNumber, bonusNumber);

        // then
        assertThat(gameResult.getWinning())
                .isEqualTo(new WinningLotto(winningNumber, bonusNumber));
    }

    @Test
    public void 수동_구매와_자동_구매() {
        int amount = 14_000;
        List<List<String>> manualLottos = new ArrayList<>();
        manualLottos.add(Arrays.asList("1", "2", "3", "4", "5", "6"));

        LottoGame lottoGame = new LottoGame(amount, manualLottos);

        assertThat(lottoGame.sizeManualLottos())
                .isEqualTo(1);

        assertThat(lottoGame.sizeAutoLottos())
                .isEqualTo(13);
    }
}
