package domain;

import enums.LottoPrize;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static domain.LottoChecker.checkWinnigLotto;
import static domain.LottoChecker.initWinnersLottos;
import static enums.LottoPrize.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoCheckerTest {
    private List<Lotto> lottos;
    @Before
    public void init() {
        lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
    @Test
    public void lottoCheckerTest() {
        //당첨 번호랑 로또 리스트를 받아서 맞춘 숫자별 리스트를 가지고 있는 셋을 반환
        Map<LottoPrize, Integer> winnerLottos = LottoChecker.getWinnerLottos(lottos, Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winnerLottos.get(FIFTH)).isEqualTo(0);
        assertThat(winnerLottos.get(FOURTH)).isEqualTo(1);
        assertThat(winnerLottos.get(THIRD)).isEqualTo(0);
        assertThat(winnerLottos.get(SECOND)).isEqualTo(0);
        assertThat(winnerLottos.get(FIRST)).isEqualTo(1);
    }

    @Test
    public void checkWinnigLottoTest() {
        Map<LottoPrize, Integer> winnerLottos = initWinnersLottos();
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winnerNums = Arrays.asList(1, 2, 3, 4, 7, 8);

        checkWinnigLotto(winnerNums, winnerLottos, lotto);
        assertThat(winnerLottos.get(FOURTH)).isEqualTo(1);
    }
}
