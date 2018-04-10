package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.List;

public class LottoGameTest {
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void 로또게임_생성_1000원으로_로또1장_구매() {
        LottoGame lottoGame = new LottoGame(1000);
        assertThat(lottoGame.getPurchasedLotto()).hasSize(1).isInstanceOf(List.class);
    }

    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void 로또게임_생성_24000원으로_로또24장_구매() {
        LottoGame lottoGame = new LottoGame(24000);
        assertThat(lottoGame.getPurchasedLotto()).hasSize(24).isInstanceOf(List.class);
    }
}
