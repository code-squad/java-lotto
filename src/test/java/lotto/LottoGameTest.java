package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class LottoGameTest {
    @Test
    public void 로또게임_생성_1000원으로_로또1장_구매() {
        LottoGame lottoGame = new LottoGame(1000);
        assertThat(lottoGame.getPurchasedLotto()).hasSize(1).isInstanceOf(List.class);
    }

    @Test
    public void 로또게임_생성_24000원으로_로또24장_구매() {
        LottoGame lottoGame = new LottoGame(24000);
        assertThat(lottoGame.getPurchasedLotto()).hasSize(24).isInstanceOf(List.class);
    }

    @Test
    public void 로또게임_생성_5000원으로_수동_3장과_자동_2장_구매() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));

        LottoGame lottoGame = new LottoGame(5000, lottos);

        assertThat(lottoGame.getPurchasedLotto()).hasSize(5);
        assertThat(lottoGame.getManualLottoCount()).isEqualTo(3);
        assertThat(lottoGame.getAutomaticLottoCount()).isEqualTo(2);
    }
}
