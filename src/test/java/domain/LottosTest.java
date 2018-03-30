package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottosTest {
    Lottos lottos;


    @Test
    public void 등수갯수_1등() {
        lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 7));
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 8));
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), Number.of(10));
        assertThat(1, is(lottos.getMatchLottos(winningLotto, Rank.FIRST)));
    }

    @Test
    public void 등수갯수_2등() {
        lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(4, 5, 7, 8, 11, 10)); // 2등
        lottos.addLottosManual(Arrays.asList(4, 5, 7, 8, 11, 10)); // 2등
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(4, 5, 7, 8, 11, 12), Number.of(10));
        assertThat(2, is(lottos.getMatchLottos(winningLotto, Rank.SECOND)));
    }

    @Test
    public void 등수갯수_3등() {
        lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 9)); // 3등
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 10));
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), Number.of(10));
        assertThat(1, is(lottos.getMatchLottos(winningLotto, Rank.THIRD)));
    }

    @Test
    public void 등수갯수_4등() {
        lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLottosManual(Arrays.asList(1, 10, 11, 12, 13, 14));
        lottos.addLottosManual(Arrays.asList(1, 10, 12, 4, 5, 6)); // 4등
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), Number.of(10));
        assertThat(1, is(lottos.getMatchLottos(winningLotto, Rank.FOURTH)));
    }

    @Test
    public void 등수갯수_5등() {
        lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 10, 11, 12)); // 5등
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 10, 11, 12)); // 5등
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 10, 11, 12)); // 5등
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), Number.of(10));
        assertThat(3, is(lottos.getMatchLottos(winningLotto, Rank.FIFTH)));
    }

    @Test
    public void 랭크결과배열출력() {
        lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 8, 9)); // FIRST
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 8, 10)); // SECOND
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 5, 14)); // FORTH
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 5, 15)); // FORTH

        /*
         * prize result;
         * FIRST -> 1
         * SECOND -> 1
         * THIRD -> 0
         * FORTH -> 2
         * FIFTH -> 0
         *
         * */

        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 7, 8, 9), Number.of(10));
        List<Rank> expected = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.FOURTH, Rank.FOURTH);
        assertThat(expected, is(lottos.getLottoRanks(winningLotto)));
    }

    @Test
    public void 최종결과반환() {
        lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 8, 9)); // FIRST
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 8, 10)); // SECOND
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 5, 14)); // FORTH
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 5, 15)); // FORTH

        /*
         * prize result;
         * FIRST -> 1
         * SECOND -> 1
         * THIRD -> 0
         * FORTH -> 2
         * FIFTH -> 0
         *
         * */

        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 7, 8, 9), Number.of(10));
        List<Integer> expected = Arrays.asList(1, 1, 0, 2, 0);
        assertThat(expected, is(lottos.getResult(winningLotto)));
    }

    @Test
    public void 수익률계산() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(11, 12, 13, 14, 15, 16));
        lottos.addLottosManual(Arrays.asList(11, 12, 13, 14, 15, 16));
        lottos.addLottosManual(Arrays.asList(11, 12, 13, 14, 15, 16));
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 9, 10, 11));
        /*
         * 5등 -> 1
         * */

        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), Number.of(10));
        assertThat(25, is(lottos.calcProfit(winningLotto)));
    }

    @Test
    public void 구입로또출력() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLottosManual(Arrays.asList(2, 3, 4, 5, 6, 7));
        String expected = "1,2,3,4,5,6\n2,3,4,5,6,7";
        assertThat(expected, is(lottos.toString()));
    }



}
