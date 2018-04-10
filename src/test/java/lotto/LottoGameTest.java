package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameTest {
    @Test
    public void 로또게임_생성_1000원으로_로또1장_구매() {
        LottoGame lottoGame = new LottoGame(1000);
        assertThat(lottoGame.lottos).hasSize(1).isInstanceOf(List.class);
    }

    @Test
    public void 로또게임_생성_24000원으로_로또24장_구매() {
        LottoGame lottoGame = new LottoGame(24000);
        assertThat(lottoGame.lottos).hasSize(24).isInstanceOf(List.class);
    }

    @Test
    public void 로또게임_플레이_로또_3장중_5등_1장_3등_3장() {
        LottoGame lottoGame = new LottoGame(3000);
        lottoGame.lottos = new ArrayList<>();
        lottoGame.lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 12)));
        lottoGame.lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 15)));
        lottoGame.lottos.add(new Lotto(Arrays.asList(1, 2, 3, 11, 14, 15)));

        assertThat(lottoGame.lottos).hasSize(3).isInstanceOf(List.class);

        GameResult gameResult = lottoGame.play(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(gameResult.winLottos.get(3)).hasSize(1).isInstanceOf(List.class);
        assertThat(gameResult.winLottos.get(5)).hasSize(2).isInstanceOf(List.class);
    }

    @Test
    public void 두개의_리스트_중복_숫자_3개() {
        assertThat(LottoGame.howManyMatchCount(new Lotto(Arrays.asList(1,2,3,4,5,6)), new Lotto(Arrays.asList(1,2,3,11,12,13)))).isEqualTo(3);
    }

    @Test
    public void 두개의_리스트_중복_숫자_6개() {
        assertThat(LottoGame.howManyMatchCount(new Lotto(Arrays.asList(1,2,3,4,5,6)), new Lotto(Arrays.asList(1,2,3,4,5,6)))).isEqualTo(6);
    }
}
